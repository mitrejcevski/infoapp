package nl.jovmit.infoapp.guides

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import nl.jovmit.infoapp.guides.data.GuidesResult
import nl.jovmit.infoapp.guides.data.Progress
import nl.jovmit.infoapp.guides.data.Success
import nl.jovmit.infoapp.setupBehaviorDelegateFor
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class GuidesLoadingTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var guidesObserver: Observer<GuidesResult>
    private lateinit var viewModel: GuidesViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        val delegate = setupBehaviorDelegateFor(GuidesApi::class.java)
        val api = GuidesApiMock(delegate)
        viewModel = GuidesViewModel(GuidesRemoteRepository(api))
    }

    @Test
    fun should_deliver_loading_to_observer_initially() {
        viewModel.guides.observeForever(guidesObserver)
        viewModel.fetchGuides()
        verify(guidesObserver).onChanged(Progress(true))
    }

    @Test
    fun should_deliver_result_to_observer_initially() {
        viewModel.guides.observeForever(guidesObserver)
        viewModel.fetchGuides()
        verify(guidesObserver).onChanged(Success(mockedGuidesResponse().guides))
    }

    @Test
    fun should_deliver_error_to_observer() {
        TODO("Error case")
    }
}