
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.fabiodrneles.myapp.Produto
import com.fabiodrneles.myapp.ui.theme.Purple500
import com.fabiodrneles.myapp.ui.theme.Teal200

@Composable
fun ProductItem(produto: Produto) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 6.dp
    ) {
        Column(
            modifier = Modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp)
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .height(imageSize)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Purple500, Teal200
                            )
                        )
                    )
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = produto.thumbnailHd,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(imageSize)
                        .clip(CircleShape)
                        .align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            Column(
                modifier = Modifier.padding(top = 8.dp, start = 16.dp)
            ) {
                Row {
                    Text(
                        text = "Nome: ",
                        maxLines = 2,
                        fontWeight = FontWeight(800)
                    )
                    Text(text = produto.title)
                }

                Row {
                    Text(
                        modifier = Modifier.padding(top = 8.dp),
                        text = "Preço: ",
                        fontSize = 14.sp,
                        fontWeight = FontWeight(800)
                    )

                    Text(
                        modifier = Modifier.padding(top = 8.dp),
                        text = produto.price,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
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
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )

                }
            }
        }
    }
}

@Preview
@Composable
fun ProductItemPreview() {
    ProductItem(produto = Produto(title = "", price = "", seller = "", thumbnailHd = ""))
}
