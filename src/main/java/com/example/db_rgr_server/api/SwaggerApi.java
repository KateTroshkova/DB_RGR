package com.example.db_rgr_server.api;

import com.example.db_rgr_server.data.network.request.BondRequest;
import com.example.db_rgr_server.data.network.request.GoodRequest;
import com.example.db_rgr_server.data.network.request.UnknownGoodRequest;
import com.example.db_rgr_server.data.network.response.IdResponse;
import com.example.db_rgr_server.model.Good;
import com.example.db_rgr_server.model.Keyword;
import io.swagger.annotations.*;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Api(value = "Good")
public interface SwaggerApi {

    @Path("/create_good")
    @POST
    @ApiOperation(httpMethod = "POST", value = "Добавить новый сувенир")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK -> Ключевое слово добавлено"),
            @ApiResponse(code = 500, message = "Error -> Not implemented yet")
    })
    IdResponse save(@ApiParam("good") UnknownGoodRequest good);

    @Path("/update_good")
    @POST
    @ApiOperation(httpMethod = "POST", value = "Обновить сувенир")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK -> Ключевое слово добавлено"),
            @ApiResponse(code = 500, message = "Error -> Not implemented yet")
    })
    void update(@ApiParam("good") GoodRequest good);

    @Path("/delete_good")
    @DELETE
    @ApiOperation(httpMethod = "DELETE", value = "Удалить сувенир")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK -> Сувенир удален"),
            @ApiResponse(code = 500, message = "Error -> Not implemented yet")
    })
    @ApiImplicitParams(@ApiImplicitParam(name = "id", value = "good id", required = true, dataType = "integer", paramType = "query"))
    IdResponse delete();

    @Path("/get_all_goods")
    @GET
    @ApiOperation(httpMethod = "GET", value = "Добавить существующее ключевое слово существующему сувениру")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK -> Ключевое слово добавлено"),
            @ApiResponse(code = 500, message = "Error -> Not implemented yet")
    })
    List<Good> loadAll();
}
