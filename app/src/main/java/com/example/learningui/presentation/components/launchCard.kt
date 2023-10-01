package com.example.learningui.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.LaunchesQuery
import com.example.learningui.ui.theme.fontFamily


@Composable
fun LaunchCard(launch: LaunchesQuery.Launch?) {


    val expanded = remember {
        mutableStateOf(false)
    }



    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Transparent)
    ) {
        val bg = createRef()

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .height(if(!expanded.value)210.dp else 410.dp)
                .constrainAs(bg) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .blur(2.dp)
                .clip(shape = RoundedCornerShape(corner = CornerSize(10.dp))),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.08F)
            )
        ) {}


        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Color.Transparent
        ) {
            Column(
                modifier = Modifier
                    .height(if(!expanded.value)255.dp else 455.dp)
                    .background(Color.Transparent)
                    .constrainAs(bg) {
                        top.linkTo(parent.top)
                    }
                    .padding(horizontal = 15.dp, vertical = 25.dp),
                verticalArrangement = Arrangement.Top
            ) {

                Text(
                    text = launch?.mission_name.toString(),
                    style = TextStyle(
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.W800,
                        fontSize = 20.sp,
                        color = Color.White
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.height(25.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {

                    Text(
                        text = launch?.rocket?.rocket_name.toString(),
                        style = TextStyle(
                            fontFamily = fontFamily,
                            fontWeight = FontWeight.W700,
                            fontSize = 19.sp,
                            color = Color(0xffE1E1E1)
                        )
                    )
                    Spacer(modifier = Modifier.width(20.dp))

                    Box(
                        modifier = Modifier
                            .width(60.dp)
                            .height(25.dp)
                            .clip(shape = RoundedCornerShape(corner = CornerSize(35.dp)))
                            .background(Color(0xFF777676))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Transparent),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = launch?.rocket?.rocket_type.toString(),
                                style = TextStyle(
                                    fontFamily = fontFamily,
                                    fontWeight = FontWeight.W700,
                                    fontSize = 14.sp,
                                    color = Color(0xFFFFFFFF)
                                )
                            )

                        }
                    }
                }


                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .padding(end = 30.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        fontFamily = fontFamily,
                        text = "Details", style = TextStyle(
                            fontWeight = FontWeight.W600,
                            fontSize = 17.sp,
                            color = Color(0xFFA3A3A3)
                        )
                    )

                    Card(
                        modifier = Modifier.size(20.dp).clickable {
                            expanded.value = !expanded.value
                        },
                        shape = RoundedCornerShape(corner = CornerSize(50)),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {

                        Icon(
                            imageVector = if (!expanded.value) Icons.Rounded.KeyboardArrowDown else Icons.Rounded.KeyboardArrowUp,
                            contentDescription = "drop-down"
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    modifier = Modifier.padding(end = 20.dp),
                    text = launch?.details.toString(),
                    maxLines = if(!expanded.value) 3 else 10,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.W600,
                        fontSize = 16.sp,
                        color = Color(0xFFFFFFFF)
                    )
                )

            }
        }
    }
}
