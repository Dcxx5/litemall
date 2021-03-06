package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.SmsFlashPromotion;
import org.linlinjava.litemall.db.domain.SmsFlashPromotionExample;

public interface SmsFlashPromotionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion
     *
     * @mbg.generated
     */
    long countByExample(SmsFlashPromotionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion
     *
     * @mbg.generated
     */
    int deleteByExample(SmsFlashPromotionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion
     *
     * @mbg.generated
     */
    int insert(SmsFlashPromotion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion
     *
     * @mbg.generated
     */
    int insertSelective(SmsFlashPromotion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SmsFlashPromotion selectOneByExample(SmsFlashPromotionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SmsFlashPromotion selectOneByExampleSelective(@Param("example") SmsFlashPromotionExample example, @Param("selective") SmsFlashPromotion.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<SmsFlashPromotion> selectByExampleSelective(@Param("example") SmsFlashPromotionExample example, @Param("selective") SmsFlashPromotion.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion
     *
     * @mbg.generated
     */
    List<SmsFlashPromotion> selectByExample(SmsFlashPromotionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SmsFlashPromotion selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") SmsFlashPromotion.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion
     *
     * @mbg.generated
     */
    SmsFlashPromotion selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SmsFlashPromotion record, @Param("example") SmsFlashPromotionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SmsFlashPromotion record, @Param("example") SmsFlashPromotionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SmsFlashPromotion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SmsFlashPromotion record);
}