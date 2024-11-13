package com.example.unit3coursepicker

import DataSource
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unit3coursepicker.model.Topic
import com.example.unit3coursepicker.ui.theme.Unit3CoursePickerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Unit3CoursePickerTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                    color = MaterialTheme.colorScheme.background,

                ){
                    CourseApp()
                }

            }
        }
    }
}



@Composable
fun CourseCard(topic:Topic, modifier: Modifier = Modifier){
    Card(modifier = modifier
        .height(68.dp)
        .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.stringResourceId),
                modifier = Modifier
                    .height(68.dp)
                    .width(68.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier, ) {
                Text(
                    text = LocalContext.current.getString(topic.stringResourceId),
                    modifier = Modifier.padding(start = 16.dp, bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = "",
                        modifier = Modifier.padding(start= 16.dp, end= 8.dp).height(16.dp).width(16.dp),
                    )
                    Text(
                        text = "${topic.numberOfCourses}",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

@Composable
fun CourseList(courseList: List<Topic>, modifier: Modifier = Modifier ) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
    ) {
        items(courseList) { topic ->
            CourseCard(
                topic = topic,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun CourseApp() {

    CourseList(
        courseList = DataSource().loadTopics()
    )
}




@Preview
@Composable
fun GreetingPreview() {
    Unit3CoursePickerTheme {
        CourseApp()
    }
}