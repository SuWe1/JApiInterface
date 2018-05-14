package com.swy.servlet;

import com.swy.model.CommonModel;
import com.swy.model.DevBusiness;
import com.swy.model.DevModel;
import com.swy.utils.ConstantUtil;
import com.swy.utils.GsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.function.Consumer;

/**
 * created by Swy on 5/14/2018
 */
@WebServlet(name = "DevServlet")
public class DevServlet extends HttpServlet {

    DevBusiness devBusiness = new DevBusiness();

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("servlet初始化……");
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<h2>hello swy , this message come from servlet</h2>");

        System.out.println("request Url : " + request.getRequestURL());
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=utf-8");
        String url = String.valueOf(request.getRequestURL());
        if (url.equals(ConstantUtil.ALL_DEVELOPERS_URL)) {
            getAllDevelopers(request, response);
        } else if (url.equals(ConstantUtil.ADD_DEVELOPER_URL)) {
            addDeveloper(request, response);
        } else if (url.equals(ConstantUtil.QUERY_DEVELOPER_URL)) {
            getDeveloper(request, response);
        } else if (url.equals(ConstantUtil.UPDATE_DEVELOPER_URL)) {
            updateDeveloper(request, response);
        } else if (url.equals(ConstantUtil.DELETE_DEVELOPER_URL)) {
            deleteDeveloper(request, response);
        }
    }


    /**
     * 获取所有的Dev
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void getAllDevelopers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        List<DevModel> devModelList = devBusiness.getAllDevelopers();
        CommonModel commonModel = new CommonModel();
        if (devModelList.size() > 0) {
            commonModel.setSuccess();
            commonModel.setData(devModelList);
        } else {
            commonModel.setFail();
        }
        printWriter.println(GsonUtil.bean2Json(commonModel));
        printWriter.flush();
        printWriter.close();
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void getDeveloper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        //获取参数
        String id = request.getParameter("id");
        System.out.println("dev id = " + id);
        DevModel devModel = devBusiness.getDeveloper(id);
        CommonModel commonModel = new CommonModel();
        if (devModel == null) {
            commonModel.setFail();
        } else {
            commonModel.setData(devModel);
            commonModel.setSuccess();
        }
        printWriter.println(GsonUtil.bean2Json(commonModel));
        printWriter.flush();
        printWriter.close();
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void addDeveloper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        String name = request.getParameter("name");
        String site = request.getParameter("site");
        String avatar = request.getParameter("avatar");
        System.out.println("dev name = " + name + ", site = " + site + ", avatar = " + avatar);
        CommonModel commonModel = new CommonModel();
        DevModel devModel = new DevModel();
        devModel.setName(name);
        devModel.setSite(site);
        devModel.setAvatar(avatar);
        if (devBusiness.addDeveloper(devModel)) {
            commonModel.setSuccess();
        } else {
            commonModel.setFail();
        }
        printWriter.println(GsonUtil.bean2Json(commonModel));
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void updateDeveloper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        System.out.println("dev id = " + id + ", name = " + name);
        CommonModel commonModel = new CommonModel();
        if (devBusiness.updateDeveloper(id, name)) {
            commonModel.setSuccess();
        } else {
            commonModel.setFail();
        }
        printWriter.println(GsonUtil.bean2Json(commonModel));
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void deleteDeveloper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        String id = request.getParameter("id");
        System.out.println("dev id=" + id);
        CommonModel commonModel = new CommonModel();
        if (devBusiness.deleteDeveloper(id)) {
            commonModel.setSuccess();
        } else {
            commonModel.setFail();
        }
        printWriter.println(GsonUtil.bean2Json(commonModel));
    }


    @Override
    public void destroy() {
        super.destroy();
        System.out.println("servlet销毁！");
    }
}
