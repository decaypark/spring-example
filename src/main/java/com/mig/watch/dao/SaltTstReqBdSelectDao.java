package com.mig.watch.dao;

import com.mig.watch.vo.SaltTstReqBdVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
public class SaltTstReqBdSelectDao {

    @Qualifier("tobeJdbcDataSource")
    @Autowired
    private final JdbcTemplate jdbcTemplate;


    public SaltTstReqBdSelectDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int SaltTstReqBdCnt() {
        Object[] params = new Object[] { "2022"	};
        int cnt = jdbcTemplate.queryForObject("SELECT COUNT(*) AS CNT FROM GC_NLIS.SALT_TST_REQ_BD WHERE 1=1 WHERE REQNO LIKE ?||'%'", params, Integer.class);

        return cnt;
    }

    @Transactional(readOnly=true, transactionManager = "tobeTxManager")
    public List<SaltTstReqBdVO> selectPaging(int s, int e, int fs) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("SELECT REQNO, TSTCD, TST_SEQ, LAB_DPTCD, REQ_DA, REQ_TI, TST_AMT, VAT_AMT, VAT_APLY_YN, REQ_TAMT, OUTS_CSTCD, TSTCD_KND_CD, OUTS_REQ_AMT, QADFE, TST_CNCL_YN, TST_CNCL_RSN, PKG_ID, UP_TSTCD, SPCMCD, TST_GRP_DIV_CD, RSTS_OUTP_TYP_CD, RSTS_OUTP_LNG_CD, TST_RST_FNS_DU_DA, CST_SPCM_NO, CST_TSTCD, TST_ADM_NO, EMEG_DIV_CD, CST_RMK1, CST_RMK2, ETC1, ETC2, JOB_DA, JOB_NO, EPMD_DIV_CD, FST_RNK, SPCM_COLC_DA, SPCM_COLC_TI, OUTS_AGNCD, TST_RST_TYP_CD, PAT_ADM_NO, IF_TGT_YN, REQ_INFO_CHG_YN, SCRN_DISPL_RNK, YCLCL_YN, TST_RPBP_ID, IMG_NO, TST_REQ_PROG_STAT_CD, CTN_TST_GRP_NO, CTN_TST_MI, CTN_TST_GRP_TSTCD, TAT_TGT_YN, TST_TAK_DCNT, CSTCD, TST_ADM_NO2, ACMU_CNT, CLCL_DA, CLCL_TI, ORI_REQ_DA, INS_ID, INS_DT, INS_CLS_ID, CHG_ID, CHG_DT, CHG_CLS_ID FROM GC_NLIS.SALT_TST_REQ_BD   WHERE ROWNUM <= 5000000 ")
                .append("  ORDER BY REQNO, TSTCD, TST_SEQ")
                .append("  OFFSET :OFFSET_NUM ROWS FETCH NEXT :ROWS_NUM ROWS ONLY");

        log.info("stringBuilder = {}", stringBuilder.toString());
        jdbcTemplate.setFetchSize(fs);
        return jdbcTemplate.query(stringBuilder.toString(),
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        preparedStatement.setInt(1, s);
                        preparedStatement.setInt(2, e);
                    }
                },

                new RowMapper<SaltTstReqBdVO>() {
                    @Override
                    public SaltTstReqBdVO mapRow(ResultSet rs, int i) throws SQLException {
                        SaltTstReqBdVO VO = new SaltTstReqBdVO();
                        VO.setREQNO(rs.getString("REQNO"));
                        VO.setTSTCD(rs.getString("TSTCD"));
                        VO.setTST_SEQ(rs.getString("TST_SEQ"));
                        VO.setLAB_DPTCD(rs.getString("LAB_DPTCD"));
                        VO.setREQ_DA(rs.getString("REQ_DA"));
                        VO.setREQ_TI(rs.getString("REQ_TI"));
                        VO.setTST_AMT(rs.getString("TST_AMT"));
                        VO.setVAT_AMT(rs.getString("VAT_AMT"));
                        VO.setVAT_APLY_YN(rs.getString("VAT_APLY_YN"));
                        VO.setREQ_TAMT(rs.getString("REQ_TAMT"));
                        VO.setOUTS_CSTCD(rs.getString("OUTS_CSTCD"));
                        VO.setTSTCD_KND_CD(rs.getString("TSTCD_KND_CD"));
                        VO.setOUTS_REQ_AMT(rs.getString("OUTS_REQ_AMT"));
                        VO.setQADFE(rs.getString("QADFE"));
                        VO.setTST_CNCL_YN(rs.getString("TST_CNCL_YN"));
                        VO.setTST_CNCL_RSN(rs.getString("TST_CNCL_RSN"));
                        VO.setPKG_ID(rs.getString("PKG_ID"));
                        VO.setUP_TSTCD(rs.getString("UP_TSTCD"));
                        VO.setSPCMCD(rs.getString("SPCMCD"));
                        VO.setTST_GRP_DIV_CD(rs.getString("TST_GRP_DIV_CD"));
                        VO.setRSTS_OUTP_TYP_CD(rs.getString("RSTS_OUTP_TYP_CD"));
                        VO.setRSTS_OUTP_LNG_CD(rs.getString("RSTS_OUTP_LNG_CD"));
                        VO.setTST_RST_FNS_DU_DA(rs.getString("TST_RST_FNS_DU_DA"));
                        VO.setCST_SPCM_NO(rs.getString("CST_SPCM_NO"));
                        VO.setCST_TSTCD(rs.getString("CST_TSTCD"));
                        VO.setTST_ADM_NO(rs.getString("TST_ADM_NO"));
                        VO.setEMEG_DIV_CD(rs.getString("EMEG_DIV_CD"));
                        VO.setCST_RMK1(rs.getString("CST_RMK1"));
                        VO.setCST_RMK2(rs.getString("CST_RMK2"));
                        VO.setETC1(rs.getString("ETC1"));
                        VO.setETC2(rs.getString("ETC2"));
                        VO.setJOB_DA(rs.getString("JOB_DA"));
                        VO.setJOB_NO(rs.getString("JOB_NO"));
                        VO.setEPMD_DIV_CD(rs.getString("EPMD_DIV_CD"));
                        VO.setFST_RNK(rs.getString("FST_RNK"));
                        VO.setSPCM_COLC_DA(rs.getString("SPCM_COLC_DA"));
                        VO.setSPCM_COLC_TI(rs.getString("SPCM_COLC_TI"));
                        VO.setOUTS_AGNCD(rs.getString("OUTS_AGNCD"));
                        VO.setTST_RST_TYP_CD(rs.getString("TST_RST_TYP_CD"));
                        VO.setPAT_ADM_NO(rs.getString("PAT_ADM_NO"));
                        VO.setIF_TGT_YN(rs.getString("IF_TGT_YN"));
                        VO.setREQ_INFO_CHG_YN(rs.getString("REQ_INFO_CHG_YN"));
                        VO.setSCRN_DISPL_RNK(rs.getString("SCRN_DISPL_RNK"));
                        VO.setYCLCL_YN(rs.getString("YCLCL_YN"));
                        VO.setTST_RPBP_ID(rs.getString("TST_RPBP_ID"));
                        VO.setIMG_NO(rs.getString("IMG_NO"));
                        VO.setTST_REQ_PROG_STAT_CD(rs.getString("TST_REQ_PROG_STAT_CD"));
                        VO.setCTN_TST_GRP_NO(rs.getString("CTN_TST_GRP_NO"));
                        VO.setCTN_TST_MI(rs.getString("CTN_TST_MI"));
                        VO.setCTN_TST_GRP_TSTCD(rs.getString("CTN_TST_GRP_TSTCD"));
                        VO.setTAT_TGT_YN(rs.getString("TAT_TGT_YN"));
                        VO.setTST_TAK_DCNT(rs.getString("TST_TAK_DCNT"));
                        VO.setCSTCD(rs.getString("CSTCD"));
                        VO.setTST_ADM_NO2(rs.getString("TST_ADM_NO2"));
                        VO.setACMU_CNT(rs.getString("ACMU_CNT"));
                        VO.setCLCL_DA(rs.getString("CLCL_DA"));
                        VO.setCLCL_TI(rs.getString("CLCL_TI"));
                        VO.setORI_REQ_DA(rs.getString("ORI_REQ_DA"));
                        VO.setINS_ID(rs.getString("INS_ID"));
                        VO.setINS_DT(rs.getDate("INS_DT"));
                        VO.setINS_CLS_ID(rs.getString("INS_CLS_ID"));
                        VO.setCHG_ID(rs.getString("CHG_ID"));
                        VO.setCHG_DT(rs.getDate("CHG_DT"));
                        VO.setCHG_CLS_ID(rs.getString("CHG_CLS_ID"));
                        return VO;
                    }
                });

    }

}
