package com.example.learningui.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.LaunchesQuery
import com.example.RocketsQuery
import com.example.learningui.data.GraphQlClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class SpaceXViewModel
@Inject constructor(private val graphQlClient: GraphQlClient) :
    ViewModel() {

    private val _launchesFlow = MutableStateFlow(listOf<LaunchesQuery.Launch?>())
    val launchesFlow = _launchesFlow.asStateFlow()

    suspend fun getLaunches(): List<LaunchesQuery.Launch?> {
        val result = graphQlClient.getLaunches()
        _launchesFlow.value = result

        Log.d("datagraphql in viewModel" , result.toString())
        return result
    }

    suspend fun getRockets(): List<RocketsQuery.Rocket?>{
        val result = graphQlClient.getRockets()
        Log.d("datagraphql -- rockets" , result.toString())
        return result
    }


}