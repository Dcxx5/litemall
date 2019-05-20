package org.linlinjava.litemall.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.linlinjava.litemall.db.domain.SmsFlashPromotionSession;
import org.linlinjava.litemall.db.domain.SmsFlashPromotionSessionExample;

public interface SmsFlashPromotionSessionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated
     */
    long countByExample(SmsFlashPromotionSessionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated
     */
    int deleteByExample(SmsFlashPromotionSessionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated
     */
    int insert(SmsFlashPromotionSession record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated
     */
    int insertSelective(SmsFlashPromotionSession record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SmsFlashPromotionSession selectOneByExample(SmsFlashPromotionSessionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SmsFlashPromotionSession selectOneByExampleSelective(@Param("example") SmsFlashPromotionSessionExample example, @Param("selective") SmsFlashPromotionSession.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<SmsFlashPromotionSession> selectByExampleSelective(@Param("example") SmsFlashPromotionSessionExample example, @Param("selective") SmsFlashPromotionSession.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated
     */
    List<SmsFlashPromotionSession> selectByExample(SmsFlashPromotionSessionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SmsFlashPromotionSession selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") SmsFlashPromotionSession.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated
     */
    SmsFlashPromotionSession selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SmsFlashPromotionSession record, @Param("example") SmsFlashPromotionSessionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SmsFlashPromotionSession record, @Param("example") SmsFlashPromotionSessionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SmsFlashPromotionSession record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_flash_promotion_session
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SmsFlashPromotionSession record);
}