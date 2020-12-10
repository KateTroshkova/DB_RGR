package com.example.db_rgr_server.swagger;

import com.example.db_rgr_server.network.request.*;
import com.example.db_rgr_server.network.response.IdResponse;
import com.example.db_rgr_server.database.model.Keyword;
import io.swagger.annotations.*;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Api(value = "Keyword")
public interface SwaggerKeywordApi {

    @Path("/create_keyword")
    @POST
    @ApiOperation(httpMethod = "POST", value = "Добавить новый сувенир")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK -> Ключевое слово добавлено"),
            @ApiResponse(code = 500, message = "Error -> See logs")
    })
    IdResponse save(@ApiParam("keyword") UnknownKeywordRequest keyword);

    @Path("/update_keyword")
    @POST
    @ApiOperation(httpMethod = "POST", value = "Обновить ключевое слово")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK -> Ключевое слово обновлено"),
            @ApiResponse(code = 500, message = "Error -> See logs")
    })
    void update(@ApiParam("keyword") KeywordRequest keyword);

    @Path("/delete_keyword")
    @DELETE
    @ApiOperation(httpMethod = "DELETE", value = "Удалить ключевое слово")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK -> Ключевое слово удалено"),
            @ApiResponse(code = 500, message = "Error -> See logs")
    })
    @ApiImplicitParams(@ApiImplicitParam(name = "id", value = "keyword id", required = true, dataType = "integer", paramType = "query"))
    IdResponse delete();

    @Path("/get_all_keywords")
    @GET
    @ApiOperation(httpMethod = "GET", value = "Список ключевых слов")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Error -> See logs")
    })
    List<Keyword> loadAll();
}
