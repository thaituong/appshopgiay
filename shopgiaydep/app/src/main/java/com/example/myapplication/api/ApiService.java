package com.example.myapplication.api;

import com.example.myapplication.Object.CHECKFOTP;
import com.example.myapplication.Object.DELSPGH;
import com.example.myapplication.Object.DH;
import com.example.myapplication.Object.DN;
import com.example.myapplication.Object.DiaChi;
import com.example.myapplication.Object.Email;
import com.example.myapplication.Object.LISTGIOHANG;
import com.example.myapplication.Object.LISTSP;
import com.example.myapplication.Object.LIST_BANNER;
import com.example.myapplication.Object.LIST_CT_SP;
import com.example.myapplication.Object.LIST_TB;
import com.example.myapplication.Object.LIST_TK;
import com.example.myapplication.Object.LIST_TTDH;
import com.example.myapplication.Object.MKM;
import com.example.myapplication.Object.Message;
import com.example.myapplication.Object.NHANHIEU;
import com.example.myapplication.Object.OTP;
import com.example.myapplication.Object.POSTSPGH;
import com.example.myapplication.Object.TTCN;
import com.example.myapplication.Object.TTCN_NH;
import com.example.myapplication.Object.TTCN_SUA;
import com.example.myapplication.Object.TT_CANHAN;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson=new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    ApiService apiService=new Retrofit.Builder()
            .baseUrl("https://shoes-shop-m6bc.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @POST("taikhoan/otp")
    Call<OTP> sendOTP(@Body Email email);

    @POST("taikhoan/dangky")
    Call<Message> sendTTDK(@Body TTCN ttcn);

    @POST("taikhoan/dangnhap")
    Call<Message> sendDN(@Body DN dn);

    @GET("nhanhieu")
    Call<NHANHIEU> getNH();

    @GET("sanpham")
    Call<LISTSP> getSPSKM();

    @GET("giohang")
    Call<LISTGIOHANG> getGIOHANG(@Header("accessToken") String accessToken);

    @GET("sanpham/{id}")
    Call<LIST_CT_SP> getCTSP(@Path("id") int id);

    @POST("giohang")
    Call<Message> sendSPGH(@Body POSTSPGH postspgh,@Header("accessToken") String accessToken);

    @GET("sanpham")
    Call<LISTSP> getSPNH(@Query("nhanhieu") int id);

//    @DELETE("giohang")
//    Call<Message> delSPGH(@Body DELSPGH delspgh,@Header("accessToken") String accessToken);

    @HTTP(method = "DELETE", path = "giohang", hasBody = true)
    Call<Message> delSPGH(@Header("accessToken") String accessToken, @Body DELSPGH delspgh);

    @GET("taikhoan")
    Call<TTCN_NH> getTTCN(@Header("accessToken") String accessToken);

    @POST("donhang")
    Call<Message> postDonHang(@Body DH dh,@Header("accessToken") String accessToken);

    @GET("banner")
    Call<LIST_BANNER> getBANNER();

    @PUT("giohang")
    Call<Message> putGioHang(@Body POSTSPGH postspgh,@Header("accessToken") String accessToken);

    @GET("donhang")
    Call<LIST_TTDH> getDonHang(@Header("accessToken") String accessToken);

    @PUT("donhang/{id}")
    Call<Message> putHuyDH(@Path("id") String id,@Header("accessToken") String accessToken);

    @GET("taikhoan")
    Call<TT_CANHAN> getTT_CANHAN(@Header("accessToken") String accessToken);

    @PUT("taikhoan")
    Call<Message> putTT_CANHAN(@Body TTCN_SUA ttcn_sua,@Header("accessToken") String accessToken);

    @PUT("taikhoan/editDC")
    Call<Message>putTT_DC(@Body DiaChi diachi, @Header("accessToken") String accessToken);

    @POST("taikhoan/forgot/otp")
    Call<OTP> sendFOTP(@Body Email email);
    @POST("taikhoan/checkFOTP")
    Call<Message> checkFOTP(@Body CHECKFOTP checkfotp);

    @POST("taikhoan/forgot/changepassword")
    Call<Message> postDoiMK(@Body MKM mkm);

    @GET("sanpham")
    Call<LISTSP> getSPDM(@Query("danhmuc") int id);

    @GET("thongke/{nam}/{thang}")
    Call<LIST_TK> getTK(@Path("nam") String nam,@Path("thang") String thang);

    @GET("thongbao")
    Call<LIST_TB> getTB();

}
