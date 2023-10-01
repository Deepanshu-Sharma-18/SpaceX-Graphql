package com.example.learningui.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.learningui.R
import com.example.learningui.presentation.SpaceXViewModel
import com.example.learningui.presentation.components.LaunchCard


@SuppressLint("StateFlowValueCalledInComposition", "SuspiciousIndentation")
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LaunchScreen(spacex: SpaceXViewModel) {

    LaunchedEffect(key1 = Unit, block = {
        spacex.getLaunches()
        spacex.getRockets()
    })

    val scroller = rememberScrollState()

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val imageRef = createRef()
        Image(
            painter = painterResource(id = R.drawable.untitledgg),
            contentDescription = "bg",
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(imageRef) {
                    start.linkTo(parent.start, 0.dp)
                    top.linkTo(parent.top, 0.dp)
                    end.linkTo(parent.end, 0.dp)
                    end.linkTo(parent.end, 0.dp)
                },
            contentScale = ContentScale.FillBounds
        )

        val flow by spacex.launchesFlow.collectAsState()

        Surface(
            modifier = Modifier.fillMaxSize(), color = Color.Transparent

        ) {
            Column(

                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(
                        horizontal = 20.dp, vertical = 20.dp
                    )
                    .fillMaxSize()
                    .constrainAs(imageRef) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
                    .verticalScroll(scroller)) {


                Spacer(modifier = Modifier.height(60.dp))

                Text(
                    text = "Launches",
                    color = Color(0xB0CA1478),
                    fontSize = 35.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(60.dp))

                if (flow.isEmpty()) {
                    CircularProgressIndicator()
                } else {

                    for (launch in flow) {
                        LaunchCard(launch = launch)
                    }
                }
            }
        }
    }
}
