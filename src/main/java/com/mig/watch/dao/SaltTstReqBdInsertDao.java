package com.mig.watch.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.mig.watch.vo.SaltTstReqBdVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;


@Repository
@Slf4j
public class SaltTstReqBdInsertDao {


	@Qualifier("tobeJdbcDataSource")
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	double min = 9999999;
	double ii = 0;
	
	  @Transactional(propagation = Propagation.REQUIRES_NEW, transactionManager = "tobeTxManager")
	  public void batchInsert(List<SaltTstReqBdVO> bdVo) {
			
	    StopWatch timer = new StopWatch();
	    String sql = "INSERT INTO GC_SYNC.SALT_TST_REQ_BD_TMP (REQNO,TSTCD,TST_SEQ,LAB_DPTCD,REQ_DA,REQ_TI,TST_AMT,VAT_AMT,VAT_APLY_YN,REQ_TAMT,OUTS_CSTCD,TSTCD_KND_CD,OUTS_REQ_AMT,QADFE,TST_CNCL_YN,TST_CNCL_RSN,PKG_ID,UP_TSTCD,SPCMCD,TST_GRP_DIV_CD,RSTS_OUTP_TYP_CD,RSTS_OUTP_LNG_CD,TST_RST_FNS_DU_DA,CST_SPCM_NO,CST_TSTCD,TST_ADM_NO,EMEG_DIV_CD,CST_RMK1,CST_RMK2,ETC1,ETC2,JOB_DA,JOB_NO,EPMD_DIV_CD,FST_RNK,SPCM_COLC_DA,SPCM_COLC_TI,OUTS_AGNCD,TST_RST_TYP_CD,PAT_ADM_NO,IF_TGT_YN,REQ_INFO_CHG_YN,SCRN_DISPL_RNK,YCLCL_YN,TST_RPBP_ID,IMG_NO,TST_REQ_PROG_STAT_CD,CTN_TST_GRP_NO,CTN_TST_MI,CTN_TST_GRP_TSTCD,TAT_TGT_YN,TST_TAK_DCNT,CSTCD,TST_ADM_NO2,ACMU_CNT,CLCL_DA,CLCL_TI,ORI_REQ_DA,INS_ID,INS_DT,INS_CLS_ID,CHG_ID,CHG_DT,CHG_CLS_ID)"
	        + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    timer.start(); 
	    jdbcTemplate.setFetchSize(bdVo.size());
	    jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
	        @Override
	        public void setValues(PreparedStatement ps, int i) throws SQLException {
	          SaltTstReqBdVO VO = bdVo.get(i);
	          ps.setString(1, VO.getREQNO());
	          ps.setString(2, VO.getTSTCD());
	          ps.setString(3, VO.getTST_SEQ());
	          ps.setString(4, VO.getLAB_DPTCD());
	          ps.setString(5, VO.getREQ_DA());
	          ps.setString(6, VO.getREQ_TI());
	          ps.setString(7, VO.getTST_AMT());
	          ps.setString(8, VO.getVAT_AMT());
	          ps.setString(9, VO.getVAT_APLY_YN());
	          ps.setString(10, VO.getREQ_TAMT());
	          ps.setString(11, VO.getOUTS_CSTCD());
	          ps.setString(12, VO.getTSTCD_KND_CD());
	          ps.setString(13, VO.getOUTS_REQ_AMT());
	          ps.setString(14, VO.getQADFE());
	          ps.setString(15, VO.getTST_CNCL_YN());
	          ps.setString(16, VO.getTST_CNCL_RSN());
	          ps.setString(17, VO.getPKG_ID());
	          ps.setString(18, VO.getUP_TSTCD());
	          ps.setString(19, VO.getSPCMCD());
	          ps.setString(20, VO.getTST_GRP_DIV_CD());
	          ps.setString(21, VO.getRSTS_OUTP_TYP_CD());
	          ps.setString(22, VO.getRSTS_OUTP_LNG_CD());
	          ps.setString(23, VO.getTST_RST_FNS_DU_DA());
	          ps.setString(24, VO.getCST_SPCM_NO());
	          ps.setString(25, VO.getCST_TSTCD());
	          ps.setString(26, VO.getTST_ADM_NO());
	          ps.setString(27, VO.getEMEG_DIV_CD());
	          ps.setString(28, VO.getCST_RMK1());
	          ps.setString(29, VO.getCST_RMK2());
	          ps.setString(30, VO.getETC1());
	          ps.setString(31, VO.getETC2());
	          ps.setString(32, VO.getJOB_DA());
	          ps.setString(33, VO.getJOB_NO());
	          ps.setString(34, VO.getEPMD_DIV_CD());
	          ps.setString(35, VO.getFST_RNK());
	          ps.setString(36, VO.getSPCM_COLC_DA());
	          ps.setString(37, VO.getSPCM_COLC_TI());
	          ps.setString(38, VO.getOUTS_AGNCD());
	          ps.setString(39, VO.getTST_RST_TYP_CD());
	          ps.setString(40, VO.getPAT_ADM_NO());
	          ps.setString(41, VO.getIF_TGT_YN());
	          ps.setString(42, VO.getREQ_INFO_CHG_YN());
	          ps.setString(43, VO.getSCRN_DISPL_RNK());
	          ps.setString(44, VO.getYCLCL_YN());
	          ps.setString(45, VO.getTST_RPBP_ID());
	          ps.setString(46, VO.getIMG_NO());
	          ps.setString(47, VO.getTST_REQ_PROG_STAT_CD());
	          ps.setString(48, VO.getCTN_TST_GRP_NO());
	          ps.setString(49, VO.getCTN_TST_MI());
	          ps.setString(50, VO.getCTN_TST_GRP_TSTCD());
	          ps.setString(51, VO.getTAT_TGT_YN());
	          ps.setString(52, VO.getTST_TAK_DCNT());
	          ps.setString(53, VO.getCSTCD());
	          ps.setString(54, VO.getTST_ADM_NO2());
	          ps.setString(55, VO.getACMU_CNT());
	          ps.setString(56, VO.getCLCL_DA());
	          ps.setString(57, VO.getCLCL_TI());
	          ps.setString(58, VO.getORI_REQ_DA());
	          ps.setString(59, VO.getINS_ID());
	          ps.setDate(60, (Date) VO.getINS_DT());
	          ps.setString(61, VO.getINS_CLS_ID());
	          ps.setString(62, VO.getCHG_ID());
	          ps.setDate(63, (Date) VO.getCHG_DT());
	          ps.setString(64, VO.getCHG_CLS_ID());
	          
	        }
	        @Override
	        public int getBatchSize() {
	          return bdVo.size();
	        }
	      });

	    timer.stop();
	    
	    double t = timer.getTotalTimeSeconds() / bdVo.size();
	    if(min >= t) {
	    	ii = bdVo.size();
	    	min = t;
	    }
	    log.info("batchInsert -> Total time in seconds: " + bdVo.size() +"/" + t + "/" + ii);

	  }

}
