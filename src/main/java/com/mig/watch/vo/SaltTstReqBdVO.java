package com.mig.watch.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("saltTstReqBdVO")
public class SaltTstReqBdVO{

	private String REQNO;
	private String TSTCD;
	private String TST_SEQ;
	private String LAB_DPTCD;
	private String REQ_DA;
	private String REQ_TI;
	private String TST_AMT;
	private String VAT_AMT;
	private String VAT_APLY_YN;
	private String REQ_TAMT;
	private String OUTS_CSTCD;
	private String TSTCD_KND_CD;
	private String OUTS_REQ_AMT;
	private String QADFE;
	private String TST_CNCL_YN;
	private String TST_CNCL_RSN;
	private String PKG_ID;
	private String UP_TSTCD;
	private String SPCMCD;
	private String TST_GRP_DIV_CD;
	private String RSTS_OUTP_TYP_CD;
	private String RSTS_OUTP_LNG_CD;
	private String TST_RST_FNS_DU_DA;
	private String CST_SPCM_NO;
	private String CST_TSTCD;
	private String TST_ADM_NO;
	private String EMEG_DIV_CD;
	private String CST_RMK1;
	private String CST_RMK2;
	private String ETC1;
	private String ETC2;
	private String JOB_DA;
	private String JOB_NO;
	private String EPMD_DIV_CD;
	private String FST_RNK;
	private String SPCM_COLC_DA;
	private String SPCM_COLC_TI;
	private String OUTS_AGNCD;
	private String TST_RST_TYP_CD;
	private String PAT_ADM_NO;
	private String IF_TGT_YN;
	private String REQ_INFO_CHG_YN;
	private String SCRN_DISPL_RNK;
	private String YCLCL_YN;
	private String TST_RPBP_ID;
	private String IMG_NO;
	private String TST_REQ_PROG_STAT_CD;
	private String CTN_TST_GRP_NO;
	private String CTN_TST_MI;
	private String CTN_TST_GRP_TSTCD;
	private String TAT_TGT_YN;
	private String TST_TAK_DCNT;
	private String CSTCD;
	private String TST_ADM_NO2;
	private String ACMU_CNT;
	private String CLCL_DA;
	private String CLCL_TI;
	private String ORI_REQ_DA;
	private String INS_ID;
	private Date INS_DT;
	private String INS_CLS_ID;
	private String CHG_ID;
	private Date CHG_DT;
	private String CHG_CLS_ID;

}
