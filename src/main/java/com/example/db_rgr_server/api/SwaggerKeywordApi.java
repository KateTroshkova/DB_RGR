package com.example.db_rgr_server.api;

import com.example.db_rgr_server.data.network.request.*;
import com.example.db_rgr_server.data.network.response.IdResponse;
import io.swagger.annotations.*;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Api(value = "Keyword")
public interface SwaggerKeywordApi {

    @Path("/create_keyword")
    @POST
    @ApiOperation(httpMethod = "POST", value = "Добавить новый сувенир")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK -> Ключевое слово добавлено"),
            @ApiResponse(code = 500, message = "Error -> Not implemented yet")
    })
    IdResponse save(@ApiParam("keyword") UnknownKeywordRequest good);

    @Path("/update_keyword")
    @POST
    @ApiOperation(httpMethod = "POST", value = "Обновить сувенир")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK -> Ключевое слово добавлено"),
            @ApiResponse(code = 500, message = "Error -> Not implemented yet")
    })
    void update(@ApiParam("keyword") KeywordRequest good);

    @Path("/delete_keyword")
    @DELETE
    @ApiOperation(httpMethod = "DELETE", value = "Удалить сувенир")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK -> Сувенир удален"),
            @ApiResponse(code = 500, message = "Error -> Not implemented yet")
    })
    @ApiImplicitParams(@ApiImplicitParam(name = "id", value = "good id", required = true, dataType = "integer", paramType = "query"))
    IdResponse delete();


    @Path("/add_keyword")
    @POST
    @ApiOperation(httpMethod = "POST", value = "Добавить существующее ключевое слово существующему сувениру")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK -> Ключевое слово добавлено"),
            @ApiResponse(code = 500, message = "Error -> Not implemented yet")
    })
    void addKeyword(@ApiParam("bond") BondRequest bond);
}
