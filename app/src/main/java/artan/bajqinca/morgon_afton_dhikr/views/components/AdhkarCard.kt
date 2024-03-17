package artan.bajqinca.morgon_afton_dhikr.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import artan.bajqinca.morgon_afton_dhikr.R
import artan.bajqinca.morgon_afton_dhikr.font.AvenirFontFamily
import artan.bajqinca.morgon_afton_dhikr.font.AvenirTypography
import artan.bajqinca.morgon_afton_dhikr.font.MeQuranFont

@Composable
fun AdhkarCard(
    number: Int,
    swedishText: String,
    arabicText: String,
    transliteration: String,
    source: String,
    reward: String,
    numberBackgroundColor: Color,
) {

    var showDialog by remember { mutableStateOf(false) }

    if (showDialog && reward.isNotEmpty()) {
        ShowRewardDialog(rewardText = reward) {
            showDialog = false
        }
    }

    Spacer(modifier = Modifier.height(40.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(10.dp)
            .background(colorResource(id = R.color.extra_light_beige))
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(38.dp)
                    .height(38.dp)
                    .clip(RoundedCornerShape(7.dp))
                    .background(numberBackgroundColor)
                    .padding(top = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = number.toString(),
                    style = TextStyle(
                        fontFamily = AvenirFontFamily,
                        fontWeight = FontWeight.W600,
                        fontSize = 24.sp,
                        color = colorResource(id = R.color.light_beige)
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = swedishText,
            style = AvenirTypography.titleMedium,
            color = colorResource(id = R.color.gray)
        )
        Spacer(modifier = Modifier.height(30.dp))

        // Transliteration
        Text(
            text = transliteration,
            style = AvenirTypography.titleMedium,
            color = colorResource(id = R.color.gray)
        )
        Spacer(modifier = Modifier.height(20.dp))

        // Arabic text
        Text(
            text = arabicText,
            style = TextStyle(
                fontFamily = MeQuranFont,
                fontSize = 27.sp,
                lineHeight = 45.sp,
                color = colorResource(id = R.color.gray)
            )
        )
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = source,
                style = TextStyle(
                    fontFamily = AvenirFontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 26.sp,
                    color = colorResource(id = R.color.gray)
                )
            )
            Spacer(modifier = Modifier.width(20.dp))

            if (reward.isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFBEB283))
                        .clickable { showDialog = true }
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                        .padding(top = 4.dp),
                ) {
                    Text(
                        text = "LÄS BELÖNING".uppercase(),
                        style = TextStyle(
                            fontFamily = AvenirFontFamily,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.light_beige)
                        )
                    )
                }
            }
        }
    }
}

