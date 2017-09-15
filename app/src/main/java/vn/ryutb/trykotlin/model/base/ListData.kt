package vn.ryutb.trykotlin.model.base

/**
 * Created by MyPC on 15/09/2017.
 */
data class ListData<I : BaseModel>(val page: Int, val total_results: Int, val results: ArrayList<I>) : BaseData() {


}