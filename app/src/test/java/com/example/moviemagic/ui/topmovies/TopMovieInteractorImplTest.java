package com.example.moviemagic.ui.topmovies;

import com.example.moviemagic.RxTestBase;
import com.example.moviemagic.api.DataApi;
import com.example.moviemagic.categories.UnitTest;
import com.example.moviemagic.data.ReviewResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mock;

import io.reactivex.Single;
import io.reactivex.subscribers.TestSubscriber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Test class for the @{@link TopMoviewInteractorImpl}
 */

@Category(UnitTest.class)
public class TopMovieInteractorImplTest extends RxTestBase {

    private TopMoviewInteractorImpl topMoviewInteractorImpl;

    @Mock
    DataApi mockApi;

    @Before
    public void setUp() {
        super.setUp();
        initMocks(this);
        topMoviewInteractorImpl = new TopMoviewInteractorImpl(mockApi);
    }

    @Test
    public void shouldBeTopMovieInteractor() {
        assertThat(topMoviewInteractorImpl).isInstanceOf(TopMoviewInteractor.class);

    }

    @Test
    public void getTopReviewTestSuccess() {
        TestSubscriber<ReviewResponse> testSubscriber = new TestSubscriber<>();
        topMoviewInteractorImpl = spy(topMoviewInteractorImpl);
        ReviewResponse reviewResponse = mock(ReviewResponse.class);
        Single<ReviewResponse> reviewResponseSingle = Single.just(reviewResponse);
        when(mockApi.getTopReviews(anyInt())).thenReturn(reviewResponseSingle);
        topMoviewInteractorImpl.getTopReviews(20).toFlowable().subscribe(testSubscriber);
        testScheduler.triggerActions();

        testSubscriber.assertComplete();
        testSubscriber.assertValueCount(1);
        testSubscriber.assertValue(reviewResponse);
    }

    @Test
    public void getTopReviewTestError() {
        TestSubscriber<ReviewResponse> testSubscriber = new TestSubscriber<>();
        topMoviewInteractorImpl = spy(topMoviewInteractorImpl);
        ReviewResponse reviewResponse = mock(ReviewResponse.class);
        Single<ReviewResponse> reviewResponseSingle = Single.error(new RuntimeException("error in Observable"));
        when(mockApi.getTopReviews(anyInt())).thenReturn(reviewResponseSingle);
        topMoviewInteractorImpl.getTopReviews(20).toFlowable().subscribe(testSubscriber);
        testScheduler.triggerActions();

        testSubscriber.assertError(RuntimeException.class);
        testSubscriber.assertNotComplete();
    }
}
