package com.arafat1419.medcheck.ui.features.main.home.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arafat1419.medcheck.R
import com.arafat1419.medcheck.ui.component.MainTextField
import com.arafat1419.medcheck.ui.theme.DarkBlue
import com.arafat1419.medcheck.ui.theme.LightGrey
import com.arafat1419.medcheck.utils.ComponentHelper.advancedShadow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListProductHeader(
    modifier: Modifier = Modifier,
    text: String,
    onValueChanged: (value: String) -> Unit
) {
    Row(
        modifier = modifier
    ) {
        Button(
            modifier = Modifier
                .size(40.dp)
                .advancedShadow(
                    color = LightGrey,
                    alpha = 0.2F,
                    shadowBlurRadius = 24.dp,
                    offsetY = 16.dp
                ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = DarkBlue
            ),
            contentPadding = PaddingValues(0.dp),
            elevation = ButtonDefaults.buttonElevation(0.dp),
            onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = null,
            )
        }

        MainTextField(
            modifier = Modifier
                .padding(start = 30.dp),
            hint = stringResource(R.string.search),
            text = text,
            shape = RoundedCornerShape(30.dp),
            verticalPadding = 10.dp,
            fontSize = 16.sp,
            endIcon = R.drawable.ic_search,
            isAllowEmpty = true,
        ) { value, _ ->
            onValueChanged(value)
        }
    }
}