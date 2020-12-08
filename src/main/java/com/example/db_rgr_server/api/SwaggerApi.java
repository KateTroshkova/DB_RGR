package com.example.db_rgr_server.api;

import com.example.db_rgr_server.data.network.request.BondRequest;
import com.example.db_rgr_server.data.network.request.GoodRequest;
import com.example.db_rgr_server.data.network.request.UnknownGoodRequest;
import com.example.db_rgr_server.data.network.response.IdResponse;
import io.swagger.annotations.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Api(value = "Good")
public interface SwaggerApi {

    @Path("/create_good")
    @GET
    @ApiOperation(httpMethod = "POST", value = "Добавить новый сувенир")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK -> Ключевое слово добавлено"),
            @ApiResponse(code = 500, message = "Error -> Not implemented yet")
    })
    IdResponse save(@ApiParam("good") UnknownGoodRequest good);

    @Path("/update_good")
    @GET
    @ApiOperation(httpMethod = "POST", value = "Обновить сувенир")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK -> Ключевое слово добавлено"),
            @ApiResponse(code = 500, message = "Error -> Not implemented yet")
    })
    void update(@ApiParam("good") GoodRequest good);

    @Path("/add_keyword")
    @GET
    @ApiOperation(httpMethod = "POST", value = "Добавить существующее ключевое слово существующему сувениру")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK -> Ключевое слово добавлено"),
            @ApiResponse(code = 500, message = "Error -> Not implemented yet")
    })
    void addKeyword(@ApiParam("bond") BondRequest bond);
}
