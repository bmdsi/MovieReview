package com.example.moviemagic.ui.topmovies;

import android.os.Build;
import android.support.v4.app.Fragment;

import com.example.moviemagic.App;
import com.example.moviemagic.BuildConfig;
import com.example.moviemagic.TestPageNavigationController;
import com.example.moviemagic.categories.UnitTest;
import com.example.moviemagic.core.BaseContentFragment;
import com.example.moviemagic.core.PageNavigationControlledFragment;
import com.example.moviemagic.core.PageNavigationController;
import com.example.moviemagic.data.MovieData;
import com.example.moviemagic.data.MovieDataBuilder;
import com.example.moviemagic.roboelectric.MovieMagicTestRunner;
import com.example.moviemagic.ui.moviedetail.MovieDetailFragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import static com.example.moviemagic.ui.moviedetail.MovieDetailFragment.ARGS_MOVIE_DATA;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Test class for @{@link TopMoviesFragment}
 */

@RunWith(MovieMagicTestRunner.class)
@Config(packageName = "com.example.moviemagic",
        constants = BuildConfig.class,
        sdk = Build.VERSION_CODES.M,
        application = App.class)
@Category(UnitTest.class)
public class TopMoviesFragmentTest {

    private TopMoviesFragment topMoviesFragment;

    @Before
    public void setUp() {
        initMocks(this);
        topMoviesFragment = TopMoviesFragment.newInstance();
        topMoviesFragment = spy(topMoviesFragment);
        topMoviesFragment.pageNavigationController = mock(PageNavigationController.class);
        doNothing().when(topMoviesFragment).injectDaggerMembers();
        doNothing().when(topMoviesFragment).setHomeAsUp(anyBoolean());
        doNothing().when(topMoviesFragment).setToolbarTitle(any());
    }

    @Test
    public void shouldBePageNavigationControlledFragment() {
        assertThat(topMoviesFragment).isInstanceOf(PageNavigationControlledFragment.class);
    }

    @Test
    public void shouldBeBaseContentFragment() {
        assertThat(topMoviesFragment).isInstanceOf(BaseContentFragment.class);
    }

    @Test
    public void shouldBeTopMoviesView() {
        assertThat(topMoviesFragment).isInstanceOf(TopMoviesView.class);
    }

    @Test
    public void shouldCallStartPresenting() {
        //1) Arrange

        topMoviesFragment.topMoviesPresenter = mock(TopMoviesPresenter.class);

        //2) Act
        SupportFragmentTestUtil.startFragment(topMoviesFragment, TestPageNavigationController.class);

        //3) Assert
        verify(topMoviesFragment.topMoviesPresenter).startPresenting();
    }

    @Test
    public void onStop_shouldCallStopPresenting() {
        //1) Arrange
        topMoviesFragment.topMoviesPresenter = mock(TopMoviesPresenter.class);

        //2) Act
        topMoviesFragment.onStop();

        //3) Assert
        verify(topMoviesFragment.topMoviesPresenter).stopPresenting();
    }

    @Test
    public void testOnClickIntent() {
        //1) Arrange
        MovieData movieData = new MovieDataBuilder()
                                    .setDisplayTitle("display title")
                                    .setHeadline("headline")
                                    .setMovieRating("rating")
                                    .createMovieData();

        topMoviesFragment.pageNavigationController = mock(PageNavigationController.class);

        //2) Act
        topMoviesFragment.onItemSelected(movieData);

        //3) Verify
        ArgumentCaptor<Fragment> fragmentArgumentCaptor = ArgumentCaptor.forClass(Fragment.class);
        verify(topMoviesFragment.pageNavigationController).displayChildFragment(fragmentArgumentCaptor.capture());
        MovieDetailFragment detailFragment = (MovieDetailFragment) fragmentArgumentCaptor.getValue();
        assertThat(detailFragment.getArguments().get(ARGS_MOVIE_DATA)).isEqualTo(movieData);
    }
}
