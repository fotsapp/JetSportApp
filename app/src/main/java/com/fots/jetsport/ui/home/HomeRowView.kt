package com.fots.jetsport.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumptech.glide.request.RequestOptions
import com.fots.jetsport.data.remote.FootballMatch
import com.fots.jetsport.ui.theme.normal_elevation
import com.fots.jetsport.ui.theme.normal_padding
import com.fots.jetsport.ui.theme.team_image_min_height_size
import com.fots.jetsport.ui.theme.team_image_min_width_size
import com.google.accompanist.glide.GlideImage
import androidx.compose.ui.res.stringResource
import com.fots.jetsport.R

/**
 * @author: yusuf.onder
 * @date: 25.04.2021
 */
@Composable
fun HomeRowView(footballMatch: FootballMatch) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(normal_padding),
        elevation = normal_elevation,
        shape = RoundedCornerShape(3.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = footballMatch.tournament_name?.codeName.orEmpty(),
                modifier = Modifier.padding(normal_padding)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {

                GlideImage(
                    data = footballMatch.home_team?.image.orEmpty(),
                    contentDescription = "contentDescription",
                    requestBuilder = {
                        val options = RequestOptions()
                        options.fitCenter()
                        apply(options)
                    },
                    modifier = Modifier
                        .sizeIn(
                            maxWidth = team_image_min_width_size,
                            maxHeight = team_image_min_height_size
                        )
                )

                Text(
                    text = stringResource(id = R.string.vs),
                    style = MaterialTheme.typography.body1
                )

                GlideImage(
                    data = footballMatch.visitant_team?.image.orEmpty(),
                    contentDescription = "contentDescription",
                    requestBuilder = {
                        val options = RequestOptions()
                        options.fitCenter()
                        apply(options)
                    },
                    modifier = Modifier
                        .sizeIn(
                            minWidth = team_image_min_width_size,
                            minHeight = team_image_min_height_size
                        )
                )
            }

        }

    }

}