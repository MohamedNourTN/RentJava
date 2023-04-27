/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author ThinkPad
 */
public class SMSUtil {
     private static final String ACCOUNT_SID = "AC040649c36a7ad21bd9a340510e16d172";
   // Votre jeton d'authentification Twilio
   private static final String AUTH_TOKEN = "f13b0386de5620a0a888bf0bbb500dde";
   // Votre numéro de téléphone Twilio
   private static final String TWILIO_NUMBER = "+17727736345";

   public static void sendSMS(String toPhoneNumber, String message) throws Exception {
      Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

      Message sms = Message.creator(
            new PhoneNumber(toPhoneNumber),
            new PhoneNumber(TWILIO_NUMBER),
            message
      ).create();

      System.out.println("SMS sent: " + sms.getSid());
   }
}