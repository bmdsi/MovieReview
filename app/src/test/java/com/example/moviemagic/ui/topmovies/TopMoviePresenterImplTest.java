package com.example.moviemagic.ui.topmovies;

import com.example.moviemagic.RxTestBase;
import com.example.moviemagic.categories.UnitTest;
import com.example.moviemagic.data.ReviewResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mock;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Unit tests for @{@link TopMoviePresenterImpl}
 */

@Category(UnitTest.class)
public class TopMoviePresenterImplTest extends RxTestBase {

    private TopMoviePresenterImpl presenter;

    @Mock
    TopMoviesView view;

    @Mock
    TopMoviewInteractor interactor;

    @Before
    public void setup() {
        super.setUp();
        initMocks(this);
        presenter = new TopMoviePresenterImpl(view, interactor);
    }

    @Test
    public void shouldBeTopMoviesPresenter() {
        assertThat(presenter).isInstanceOf(TopMoviesPresenter.class);
    }

    @Test
    public void testStartPresenting() {
        //1. Arrange
        presenter = spy(presenter);
        ReviewResponse mockReviewResponse = mock(ReviewResponse.class);
        when(interactor.getTopReviews(anyInt())).thenReturn(Single.just(mockReviewResponse));

        //2. Act
        presenter.startPresenting();

        //3.Assert
        verify(presenter).loadTopMovies();
    }

    @Test
    public void testStartPresentingGetReviews() {
        //1. Arrange
        presenter = spy(presenter);
        ReviewResponse mockReviewResponse = mock(ReviewResponse.class);
        when(interactor.getTopReviews(anyInt())).thenReturn(Single.just(mockReviewResponse));

        //2. Act
        presenter.startPresenting();

        //3.Assert
        verify(interactor).getTopReviews(anyInt());
    }

    @Test
    public void testStartPresentingGetReviewsSuccess() {
        //1. Arrange
        when(interactor.getTopReviews(anyInt())).thenReturn(Single.just(mock(ReviewResponse.class)));

        //2. Act
        presenter.startPresenting();

        //3.Assert
        verify(view).showLoadingIndicator();
        verify(view).displayTopMovies(anyList());
        verify(view).hideLoadingIndicator();
    }

    @Test
    public void testStartPresentingGetReviewsError() {
        //1. Arrange
        when(interactor.getTopReviews(anyInt())).thenReturn(Single.error(new Throwable()));

        //2. Act
        presenter.startPresenting();

        //3.Assert
        verify(view).showLoadingIndicator();
        verify(view).showErrorLoadingMovie();
        verify(view).hideLoadingIndicator();
    }

    @Test
    public void stopPresenting_shouldDispose() {
        //1) Arrange
        presenter.disposables = mock(CompositeDisposable.class);

        //2) Act
        presenter.stopPresenting();

        //3) Assert
        verify(presenter.disposables).dispose();
    }

}
