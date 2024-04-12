package com.fabiodrneles.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.fabiodrneles.myapp.ui.theme.MyAppTheme


class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                ListaDeProdutos(viewModel = viewModel)
                //ProductItem(produto = Produto(title = "", price = "", seller = "", thumbnailHd = ""))
            }
        }
    }
}


@Composable
fun ListaDeProdutos(viewModel: MainViewModel) {

    val produtos by remember { viewModel.produtos }

    LaunchedEffect(Unit) {
        viewModel.getProdutos()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()

    ) {
        items(produtos) { produto ->

            Column(
                modifier = Modifier
                    .padding(16.dp)

            ) {
                AsyncImage(
                    model = produto.thumbnailHd,
                    contentDescription = null,
                    // quando o endereço da imagem não rodar.
                    error = painterResource(id = R.drawable.ic_launcher_background),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(100.dp)
                        .align(Alignment.Start)
                )


                Column(
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Row {
                        Text(
                            modifier = Modifier.padding(top = 8.dp),
                            text = produto.title,
                            maxLines = 2,
                            fontSize = 14.sp,
                            fontWeight = FontWeight(700),
                            fontStyle = FontStyle.Italic
                        )
                    }
                    Row {
                        Text(
                            modifier = Modifier.padding(top = 8.dp),
                            text = "Preço: ",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            modifier = Modifier.padding(top = 8.dp),
                            text = produto.price,
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            fontStyle = FontStyle.Italic

                        )
                    }
                    Row {
                        Text(
                            modifier = Modifier.padding(top = 8.dp),
                            text = "Vendedor: ",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            modifier = Modifier.padding(top = 8.dp),
                            text = produto.seller,
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            fontStyle = FontStyle.Italic
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ListaDeProdutosPreview() {
    ListaDeProdutos(viewModel = viewModel())
}