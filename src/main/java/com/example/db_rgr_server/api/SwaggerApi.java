package com.example.db_rgr_server.api;

import com.example.db_rgr_server.data.network.request.BondRequest;
import com.example.db_rgr_server.data.network.request.UnknownGoodRequest;
import com.example.db_rgr_server.data.network.response.IdResponse;
import com.example.db_rgr_server.model.Good;
import io.swagger.annotations.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Api(value = "Good")
public interface SwaggerApi {
    @Path("/get_goods")
    @GET
    @ApiOperation(httpMethod = "GET", value = "Resource to get a list of goods")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK -> The user has been fetched successfully"),
            @ApiResponse(code = 201, message = "OK -> The user has been created successfully"),
            @ApiResponse(code = 202, message = "Accepted -> The user has been updated successfully"),
            @ApiResponse(code = 204, message = "NO CONTENT -> The user has been removed successfully")
    })
    public List<Good> loadAll();

    @Path("/create_good")
    @GET
    @ApiOperation(httpMethod = "POST", value = "Добавить новый сувенир")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK -> Ключевое слово добавлено"),
            @ApiResponse(code = 500, message = "Error -> Not implemented yet")
    })
    IdResponse save(@ApiParam("good") UnknownGoodRequest good);

    @Path("/add_keyword")
    @GET
    @ApiOperation(httpMethod = "POST", value = "Добавить существующее ключевое слово существующему сувениру")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK -> Ключевое слово добавлено"),
            @ApiResponse(code = 500, message = "Error -> Not implemented yet")
    })
    void addKeyword(@ApiParam("bond") BondRequest bond);
}
