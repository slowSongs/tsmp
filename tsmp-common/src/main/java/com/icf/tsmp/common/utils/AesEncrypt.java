package com.icf.tsmp.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import java.security.*;

/**
 * @auhther Arvin
 * @date 2020/7/2 15:38
 * @description:
 */


public class AesEncrypt {
    private static final Logger logger =LoggerFactory.getLogger(AesEncrypt .class);
    private static final String SIGNATURE_ALGORITHM = "SHA1WithRSA";
    private static final String PATTERN = "AES/CBC/PKCS5Padding";

    /**
     * 使用公钥判断签名是否与数据匹配
     * @param encrypyByte 数据
     * @param bs 签名
     * @param publickey 公钥
     * @return 是否篡改了公钥
     */
    public static boolean docheck(byte[] encrypyByte, byte[] bs, PublicKey publickey) {
        try {
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initVerify(publickey);
            signature.update(encrypyByte);
            boolean bverify = signature.verify(bs);
            return bverify;
        } catch (Exception e) {
            logger.error("用公钥判断签名是否与数据匹配异常，数据信息：{}", new String(encrypyByte), e);
        }
        return false;
    }

    /**
     * AES 加密
     * @param data
     * @param key
     * @param IV_STRING
     * @return
     */
//    public static String encryptAES(String data, String key, String IV_STRING) {
////        try {
////            Key keySpec = new SecretKey(key.getBytes(), "AES");
////            IvParameterSpec ivSpec = new IvParameterSpec(IV_STRING.getBytes());
////            Cipher cipher = Cipher.getInstance(PATTERN);
////            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
////            byte[] b = cipher.doFinal(data.getBytes("utf-8"));
////            String ret = new String(new BASE64Encoder().encode(b));
////            return ret;
////        } catch (Exception e) {
////            logger.error("encrypt fail,error+", e);
////        }
////        return null;
////    }
}
