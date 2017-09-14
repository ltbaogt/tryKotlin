package vn.ryutb.trykotlin.model

import vn.ryutb.trykotlin.model.base.BaseData
import vn.ryutb.trykotlin.model.base.BaseResponse

/**
 * Created by MyPC on 15/09/2017.
 */
data class ObjectResponse<D : BaseData>(override val data: D) : BaseResponse<D>(){
}