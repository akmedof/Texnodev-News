package com.aslangroup.texnodev.presentaion.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aslangroup.texnodev.R
import com.aslangroup.texnodev.app.theme.AuthorBoxTransparent
import com.aslangroup.texnodev.app.theme.BackgroundComponent
import com.aslangroup.texnodev.app.theme.BlueMain
import com.aslangroup.texnodev.app.theme.Dark
import com.aslangroup.texnodev.app.theme.DarkGray
import com.aslangroup.texnodev.app.theme.Transparent
import com.aslangroup.texnodev.app.theme.White

@Composable
fun PostComponent(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(top = 10.dp)
            .fillMaxWidth()
            .height(225.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.test_news_post_img),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 25.dp)
                .clip(shape = RoundedCornerShape(10))
                .clickable(onClick = {})
        )
        Box(
            modifier = modifier
                .padding(bottom = 25.dp)
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(10))
                .background(
                    Brush.verticalGradient(
                        colorStops = arrayOf(
                            Pair(0.25f, Transparent),
                            Pair(1f, DarkGray),
                        )
                    )
                )
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .padding(10.dp)
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {
            PostAuthor()
            PostFavorite()
        }
        Column(
            modifier = modifier.align(Alignment.BottomCenter)
        ) {
            Text(
                text = "Notbuk Apple MacBook Air 15 MQKP3RUA Space Grey le MacBook Air 15 MQKP3RUA Space Grey hjgjhjgg",
                color = White,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                maxLines = 2,
                modifier = modifier
                    .padding(horizontal = 10.dp)
                    .padding(bottom = 10.dp)
            )
            PostBottomDetails()
        }
    }
}

@Composable
private fun PostFavorite(modifier: Modifier = Modifier) {
    var isCheck by remember { mutableStateOf(false) }
    val icon = if (isCheck) R.drawable.favorite_active else R.drawable.favorite_inactive
    Box(
        modifier = modifier
            .size(40.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(AuthorBoxTransparent)
            .clickable { isCheck = !isCheck }
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "",
            tint = BlueMain,
            modifier = modifier
                .size(18.dp)
                .clip(RoundedCornerShape(100))
                .align(Alignment.Center)
        )
    }
}

@Composable
private fun PostAuthor(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .clip(RoundedCornerShape(100.dp))
            .background(AuthorBoxTransparent)
            .padding(PaddingValues(horizontal = 15.dp, vertical = 10.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.test_news_post_img),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(25.dp)
                .clip(RoundedCornerShape(100))
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(text = "Author", color = White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Image(
                painter = painterResource(id = R.drawable.author_verify),
                contentDescription = "",
                modifier = modifier.size(16.dp)
            )
        }
    }
}

@Composable
private fun PostBottomDetails(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(10.dp))
//            .background(White.copy(0.5f))
            .background(MaterialTheme.colors.BackgroundComponent)

    ) {
        PostCategories(categories = listOf("Moda", "Tech", "Game", "Tech", "Addidsa",), modifier.weight(6f))
//        PostViewCount(icon = R.drawable.post_view_icon, count = 777)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = modifier.padding(end = 10.dp)
        ) {
            PostViewCount(icon = R.drawable.post_view_icon, count = 777)
            PostViewCount(icon = R.drawable.post_like_icon, count = 97)
        }
    }
}

@Composable
private fun PostCategories(
    categories: List<String>,
    modifier: Modifier = Modifier
) {
    LazyRow(modifier = modifier.padding(horizontal = 5.dp)) {
        items(items = categories) { item ->
            Box(modifier = modifier
                .clip(RoundedCornerShape(100.dp))
                .background(MaterialTheme.colors.BackgroundComponent.copy(0.8f))
                .padding(PaddingValues(5.dp))
            ) {
                Text(text = item, color = White, fontWeight = FontWeight.W300, fontSize = 14.sp)
            }
        }
    }
}

@Composable
private fun PostViewCount(
    icon: Int,
    count: Int,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "",
            modifier = modifier.size(18.dp)
        )
        Text(
            text = count.toString(),
            color = White,
            fontFamily = FontFamily.SansSerif,
            fontSize = 14.sp
        )
    }
}