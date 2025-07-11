package org.example.rickmotryapp.ui.core.components

import androidx.compose.foundation.HorizontalScrollbar
import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.LazyPagingItems
import org.example.rickmotryapp.ui.core.Green

@Composable
actual fun <T : Any> LazyRowTarget(
    pagingItems: LazyPagingItems<T>,
    itemView: @Composable (T) -> Unit
) {
    val lazyState = rememberLazyListState()
    Column {

        LazyRow(state = lazyState) {
            items(pagingItems.itemCount) { pos ->
                pagingItems[pos]?.let { item ->
                    itemView(item)
                }
            }
        }
        Spacer(Modifier.height(2.dp))
        HorizontalScrollbar(adapter = rememberScrollbarAdapter(lazyState), style = LocalScrollbarStyle.current.copy(
           unhoverColor = Green.copy(alpha = 0.4f),
            hoverColor = Green
        ))

    }
}