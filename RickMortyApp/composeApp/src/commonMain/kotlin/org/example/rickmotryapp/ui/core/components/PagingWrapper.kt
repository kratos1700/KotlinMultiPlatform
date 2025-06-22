package org.example.rickmotryapp.ui.core.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems


enum class PagingType {
    ROW,
    COLUMN,
    VERTICAL_GRID,
   // HORIZONTAL_GRID
}

/*
 * A wrapper para paginación de datos en Compose, es una funcion lambda generica que recibe
 * un Flow de PagingData y un lambda que recibe un item y retorna un Composable
 */
@Composable
fun <T : Any> PagingWrapper(
    pagingType: PagingType,
    pagingItems: LazyPagingItems<T>,
    itemView: @Composable (T) -> Unit,
    initialView: @Composable () -> Unit = {},
    emptyView: @Composable () -> Unit = {},
    extraItemsView: @Composable () -> Unit = {},
    header: @Composable () -> Unit = {},
) {
    when {
        pagingItems.loadState.refresh is LoadState.Loading && pagingItems.itemCount == 0 -> {
            initialView()
        }

        pagingItems.loadState.refresh is LoadState.NotLoading && pagingItems.itemCount == 0 -> {
            emptyView()
        }

        else -> {
            when (pagingType){
                PagingType.ROW -> {
                    LazyRowTarget( pagingItems, itemView)
                }
                PagingType.COLUMN -> {
                    LazyColumn {
                        items(pagingItems.itemCount) { pos ->
                            pagingItems[pos]?.let { item ->
                                itemView(item)

                            }
                        }
                    }
                }
                PagingType.VERTICAL_GRID -> {
                  LazyVerticalGridTarget(pagingItems, itemView, header)
                }
            }


            if (pagingItems.loadState.append is LoadState.Loading) {
                extraItemsView()
            }
        }

    }

}