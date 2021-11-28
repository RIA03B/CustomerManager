package com.customermanager.enterprise.dao;

import com.customermanager.enterprise.dto.imported;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface IImportedRetrofitDAO {

    // Still waiting on VarmentTMS to upload their end point
    @GET("/perl/mobile/viewplantsjsonarray.pl")
    Call<List<imported>> getImports();
}
