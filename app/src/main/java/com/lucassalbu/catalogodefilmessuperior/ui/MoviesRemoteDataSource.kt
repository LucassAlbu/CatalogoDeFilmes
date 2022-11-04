//package com.lucassalbu.catalogodefilmessuperior.ui
//
//import androidx.paging.Pager
//import androidx.paging.PagingConfig
//import androidx.paging.PagingData
//import com.lucassalbu.catalogodefilmessuperior.models.MoviesModel
//import kotlinx.coroutines.flow.Flow
//
//
//const val NETWORK_PAGE_SIZE = 25
//
//open class MoviesRemoteDataSource {
//
//    internal class MoviesRemoteDataSourceImpl(
//        private val movieService: MoviesModel
//    ) : MoviesRemoteDataSource() {
//
//        override fun getMovies(): Flow<PagingData<MoviesModel>> {
//            return Pager(
//                config = PagingConfig(
//                    pageSize = NETWORK_PAGE_SIZE,
//                    enablePlaceholders = false
//                ),
//                pagingSourceFactory = {
//                    MoviesPagingSource(service = MoviesModel)
//                }
//            ).flow
//        }
//    }
//}