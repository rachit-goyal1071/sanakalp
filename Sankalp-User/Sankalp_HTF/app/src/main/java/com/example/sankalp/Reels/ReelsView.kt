package com.example.sankalp.Reels

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.bumptech.glide.integration.compose.GlideImage
import com.example.sankalp.R
import com.skydoves.landscapist.glide.GlideImage

val verticalPadding = 12.dp
val horizontalPadding = 10.dp

@Composable
fun ReelsView() {
    Box(modifier = Modifier.background(color = Color.Black)) {

        ReelsHeader()
        ReelsList()
    }
}

@Composable
fun ReelsHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = horizontalPadding,
                vertical = verticalPadding
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Reels", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 21.sp)
        Icon(
            bitmap = ImageBitmap.imageResource(id = R.drawable.ic_outlined_camera),
            tint = Color.White,
            modifier = Modifier.size(24.dp),
            contentDescription = null
        )
    }
}


@Composable
fun ReelsList() {
    val reels = DummyData.reels
    Log.d("idk", "ReelsList: ${reels.size}")
    LazyColumn {
        items(reels.size) { index ->
            Log.d("idk", "ReelsList index: ${index} ")
            Box(Modifier.fillParentMaxSize()) {
                Log.d("idk", "reel url:${reels[index].getVideoUrl()} ")
                VideoPlayer(uri = reels[index].getVideoUrl())
                Column(Modifier.align(Alignment.BottomStart)) {
                    ReelFooter(reels[index])
                    Divider()
                }
            }
        }
    }
}

@Composable
fun ReelFooter(reel: Reel) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 18.dp, bottom = 18.dp), verticalAlignment = Alignment.Bottom
    ) {
        FooterUserData(
            reel = reel,
            modifier = Modifier.weight(8f)
        )

        FooterUserAction(
            reel = reel,
            modifier = Modifier.weight(2f)
        )
    }
}

@Composable
fun FooterUserAction(reel: Reel, modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        UserActionWithText(
            drawableRes = R.drawable.ic_outlined_favorite,
            text = reel.likesCount.toString()
        )
        Spacer(modifier = Modifier.height(28.dp))
        UserActionWithText(
            drawableRes = R.drawable.ic_outlined_comment,
            text = reel.commentsCount.toString()
        )
        Spacer(modifier = Modifier.height(28.dp))
        UserAction(drawableRes = R.drawable.ic_dm)
        Spacer(modifier = Modifier.height(28.dp))
        Icon(imageVector = Icons.Default.MoreVert, contentDescription = null, tint = Color.White)
        Spacer(modifier = Modifier.height(28.dp))

        GlideImage(
            imageModel = { reel.userImage },
            modifier = Modifier
                .size(28.dp)
                .background(color = Color.Gray, shape = RoundedCornerShape(6.dp))
                .clip(RoundedCornerShape(6.dp)),
        )
    }
}

@Composable
fun UserAction(@DrawableRes drawableRes: Int) {
    Icon(
        bitmap = ImageBitmap.imageResource(id = drawableRes),
        tint = Color.White,
        modifier = Modifier.size(16.dp),
        contentDescription = null
    )
}

@Composable
fun UserActionWithText(
    @DrawableRes drawableRes: Int,
    text: String
) {
    Icon(
        bitmap = ImageBitmap.imageResource(id = drawableRes),
        tint = Color.White,
        modifier = Modifier.size(28.dp),
        contentDescription = null
    )
    Spacer(modifier = Modifier.height(6.dp))
    Text(
        text = text,
        color = Color.White,
        fontSize = 13.sp,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun FooterUserData(reel: Reel, modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            GlideImage(
                imageModel = {reel.userImage},
//                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(28.dp)
                    .background(color = Color.Gray, shape = CircleShape)
                    .clip(CircleShape),
            )

            Spacer(modifier = Modifier.width(horizontalPadding))
            Text(
                text = reel.userName,
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium//kuch aur tha
            )

            Spacer(modifier = Modifier.width(horizontalPadding))
            Canvas(modifier = Modifier.size(5.dp), onDraw = {
                drawCircle(
                    color = Color.White,
                    radius = 8f
                )
            })
            Spacer(modifier = Modifier.width(horizontalPadding))
            Text(
                text = "Follow",
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium // kuch aur tha
            )
        }

        Spacer(modifier = Modifier.height(horizontalPadding))
        Text(text = reel.comment, color = Color.White)
        Spacer(modifier = Modifier.height(horizontalPadding))


        // Audio
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(reel.userName, color = Color.White)
            Spacer(modifier = Modifier.width(horizontalPadding))
            Canvas(modifier = Modifier.size(5.dp), onDraw = {
                drawCircle(
                    color = Color.White,
                    radius = 8f
                )
            })
            Spacer(modifier = Modifier.width(horizontalPadding))
            Text(
                text = "Audio asli",
                color = Color.White
            )
        }
    }
}


