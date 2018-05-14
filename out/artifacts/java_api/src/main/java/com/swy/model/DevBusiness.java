package com.swy.model;

import com.swy.dao.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DevBusiness {

    /**
     * 获取数据库中所有的Dev
     *
     * @return
     */
    public List<DevModel> getAllDevelopers() {
        List<DevModel> allDevList = new ArrayList<>();
        String sql = " select * from devandroid";
        DBHelper dbHelper = new DBHelper(sql);
        ResultSet resultSet = null;
        try {
            resultSet = dbHelper.preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String site = resultSet.getString(3);
                String avatar = resultSet.getString(4);
                DevModel devItem = new DevModel();
                devItem.setId(id);
                devItem.setName(name);
                devItem.setSite(site);
                devItem.setAvatar(avatar);
                allDevList.add(devItem);
            }
            //释放资源
            resultSet.close();
            dbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allDevList;
    }

    /**
     * 根据ID获取数据库中的Dev
     *
     * @param devID 对应要获取的Dev的唯一ID
     * @return
     */
    public DevModel getDeveloper(String devID) {
        String sql = "select * from devandroid wherr id=" + devID;
        DBHelper dbHelper = new DBHelper(sql);
        DevModel devModel = new DevModel();
        try {
            ResultSet resultSet = dbHelper.preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String site = resultSet.getString(3);
                String avatar = resultSet.getString(4);
                DevModel devItem = new DevModel();
                devItem.setId(id);
                devItem.setName(name);
                devItem.setSite(site);
                devItem.setAvatar(avatar);
            }
            //释放资源
            resultSet.close();
            dbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return devModel;
    }

    /**
     * 添加Dev
     *
     * @param devModel
     * @return
     */
    public boolean addDeveloper(DevModel devModel) {
        String sql = "insert into devandroid(name,site,avatar) values(" +
                "'" + devModel.getName() + "'," +
                "'" + devModel.getSite() + "'," +
                "'" + devModel.getAvatar() + "'," + ");";
        System.out.println("addDeveloper sql = " + sql);
        DBHelper dbHelper = new DBHelper(sql);
        return execute(dbHelper);
    }

    private boolean execute(DBHelper dbHelper) {
        try {
            dbHelper.preparedStatement.execute();
            dbHelper.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据ID修改Dev.name
     *
     * @param id
     * @param name
     * @return
     */
    public boolean updateDeveloper(String id, String name) {
        String sql = "update devandroid set name='" + name + "' where id=" + id;
        System.out.println("updateDeveloper sql = " + sql);
        DBHelper dbHelper = new DBHelper(sql);
        try {
            dbHelper.preparedStatement.executeUpdate();
            dbHelper.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据ID删除Dev
     *
     * @param id
     * @return
     */
    public boolean deleteDeveloper(String id) {
        String sql = "delete from devandroid where id=" + id;
        System.out.println("deleteDeveloper sql = " + sql);
        DBHelper dbHelper = new DBHelper(sql);
        try {
            dbHelper.preparedStatement.executeUpdate();
            dbHelper.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
