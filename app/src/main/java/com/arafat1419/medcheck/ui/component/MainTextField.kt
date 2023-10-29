package com.arafat1419.medcheck.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arafat1419.core.utils.CommonUtils
import com.arafat1419.medcheck.R
import com.arafat1419.medcheck.ui.theme.DarkBlue
import com.arafat1419.medcheck.ui.theme.Grey
import com.arafat1419.medcheck.ui.theme.LightGrey
import com.arafat1419.medcheck.ui.theme.ProximaNovaFontFamily
import com.arafat1419.medcheck.ui.theme.Red60
import com.arafat1419.medcheck.utils.ComponentHelper.advancedShadow

@ExperimentalMaterial3Api
@Composable
fun MainTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String? = null,
    shape: Shape = RoundedCornerShape(8.dp),
    verticalPadding: Dp = 12.dp,
    fontSize: TextUnit = 12.sp,
    @DrawableRes endIcon: Int? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    isAllowEmpty: Boolean = false,
    endIconClicked: () -> Unit = {},
    onValueChanged: (value: String, isError: Boolean) -> Unit = { _, _ -> }
) {
    var isShowValue by remember {
        mutableStateOf(false)
    }

    val isPassword =
        (keyboardType == KeyboardType.Password || keyboardType == KeyboardType.NumberPassword)

    val visualTransformation =
        if (isPassword && !isShowValue) PasswordVisualTransformation() else VisualTransformation.None

    var validationError by remember { mutableStateOf(if (isAllowEmpty) null else "Data tidak boleh kosong") }

    Column(
        modifier = modifier
    ) {
        BasicTextField(
            value = text,
            onValueChange = {
                validationError = CommonUtils.isValidInput(it, keyboardType, isAllowEmpty)
                onValueChanged(it, validationError != null)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .advancedShadow(
                    color = LightGrey,
                    alpha = 0.2F,
                    shadowBlurRadius = 24.dp,
                    offsetY = 16.dp
                ),
            textStyle = TextStyle(
                color = DarkBlue,
                fontSize = fontSize,
                fontFamily = ProximaNovaFontFamily,
                fontWeight = FontWeight.SemiBold
            ),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            singleLine = true,
            visualTransformation = visualTransformation,
            decorationBox = @Composable { innerTextField ->
                TextFieldDefaults.TextFieldDecorationBox(
                    value = text,
                    innerTextField = innerTextField,
                    enabled = true,
                    singleLine = true,
                    visualTransformation = visualTransformation,
                    interactionSource = remember { MutableInteractionSource() },
                    trailingIcon = {
                        Row {
                            if (text != "") {
                                IconButton(
                                    onClick = {
                                        validationError =
                                            if (isAllowEmpty) null else "Data tidak boleh kosong"
                                        onValueChanged("", validationError != null)
                                    }) {
                                    Icon(
                                        modifier = Modifier
                                            .size(16.dp),
                                        painter = painterResource(id = R.drawable.ic_close),
                                        contentDescription = null,
                                        tint = DarkBlue
                                    )
                                }
                            }

                            if (endIcon != null) {
                                IconButton(
                                    modifier = Modifier.padding(end = 12.dp),
                                    onClick = {
                                        endIconClicked()
                                    }) {
                                    Icon(
                                        modifier = Modifier
                                            .size(16.dp),
                                        painter = painterResource(id = endIcon),
                                        contentDescription = null,
                                        tint = DarkBlue
                                    )
                                }
                            }

                            if (isPassword) {
                                IconButton(
                                    modifier = Modifier.padding(end = 12.dp),
                                    onClick = {
                                        isShowValue = !isShowValue
                                    }) {
                                    Icon(
                                        modifier = Modifier
                                            .size(16.dp),
                                        painter = painterResource(id = if (isShowValue) R.drawable.ic_open_eye else R.drawable.ic_close_eye),
                                        contentDescription = null,
                                        tint = DarkBlue
                                    )
                                }
                            }
                        }
                    },
                    placeholder = {
                        if (hint != null) {
                            Text(
                                text = hint,
                                color = Grey,
                                fontSize = fontSize,
                                fontFamily = ProximaNovaFontFamily,
                                fontWeight = FontWeight.Normal,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1
                            )
                        }
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        containerColor = Color.White,
                        cursorColor = LightGrey
                    ),
                    contentPadding = TextFieldDefaults.textFieldWithoutLabelPadding(
                        start = 24.dp,
                        top = verticalPadding,
                        end = if (endIcon != null) 16.dp else 24.dp,
                        bottom = verticalPadding
                    ),
                    shape = shape
                )
            }
        )

        if (validationError != null) {
            Text(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                text = validationError!!,
                color = Red60,
                fontSize = 12.sp,
                fontFamily = ProximaNovaFontFamily,
                fontWeight = FontWeight.Normal,
            )
        }
    }
}