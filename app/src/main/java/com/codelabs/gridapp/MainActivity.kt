package com.codelabs.gridapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelabs.gridapp.data.DataSource
import com.codelabs.gridapp.model.Topic
import com.codelabs.gridapp.ui.theme.GridAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GridAppTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                ) {
                    Grid(
                        modifier = Modifier
                            .padding(
                                top = 8.dp,
                                start = 8.dp,
                                end = 8.dp
                            )
                    )
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    Grid()
}

@Preview(showBackground = true)
@Composable
fun GridPreview() {
    Grid(modifier = Modifier
        .padding(
            top = 8.dp,
            start = 8.dp,
            end = 8.dp
        )
    )
}

@Composable
fun Grid (modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(DataSource.topics){
            topic -> TopicCard(topic)
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier:Modifier = Modifier)
{
    Card{
        Row {
            Image (
                painter = painterResource(id = topic.idImage),
                contentDescription = stringResource(id = topic.idLabel),
                contentScale = ContentScale.Crop,
                modifier = Modifier.width(68.dp).height(68.dp)
            )
            Column {
                Text(
                    text = stringResource(id = topic.idLabel),
                    //alternativamente a fontWeight podemos usar style
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    )
                )
                Row {
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = "an icon representing subscriptors",
                        modifier = Modifier.padding(start = 16.dp, end = 8.dp)
                    )
                    Text(
                        text = topic.suscriptors.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.align(alignment = Alignment.CenterVertically)
                    )
                }
            }

        }
    }

}