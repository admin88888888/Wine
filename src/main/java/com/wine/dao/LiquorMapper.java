package com.wine.dao;

import com.wine.entity.Liquor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LiquorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Liquor record);

    int insertSelective(Liquor record);

    Liquor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Liquor record);

    int updateByPrimaryKey(Liquor record);

    /**
     * 获取A区22个特别推荐信息
     * @return
     */
    List<Liquor> selectLiquorRecommend();

    /**
     * 获取畅销新品招商信息
     * @return
     */
    List<Liquor> selectGoodsNewJion();

    /**
     * 获取B区 招商爆款-综合酒水
     * @return
     */
    List<Liquor> selectSynthesizeLiquor();

    List<Liquor> selectjiu(@Param("kind") String kind,@Param("searchstr") String searchstr);

    List<Liquor> reselect();

    List<Liquor> mingjiudaili();


    /**
     * 招商C区-综合酒水(啤酒)
     * @return
     */
    List<Liquor> selectPLiquor();

    /**
     * 招商D区-综合酒水(葡萄酒)
     * @return
     */
    List<Liquor> selectPuTaoLiquor();

    /**
     * 招商E区-综合酒水(洋酒)
     * @return
     */
    List<Liquor> selectYangLiquor();

    /**
     * 招商F区-综合酒水(白酒)
     * @return
     */
    List<Liquor> selectBaiLiquor();

    /**
     * 招商G区-综合酒水(黄酒)
     * @return
     */
    List<Liquor> selectYellowLiquor();

    /**
     * 招商J区-综合酒水
     * @return
     */
    List<Liquor> selectJLiquor();

    /**
     * 爆款招商区
     * @return
     */
    List<Liquor> selectHotLiquor();

    /**
     * 特惠招商区
     * @return
     */
    List<Liquor> selectLitterLiquor();


}