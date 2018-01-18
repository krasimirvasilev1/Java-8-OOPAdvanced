package NinethLectureObjectCommunication.logger.models;

import NinethLectureObjectCommunication.command.enums.LogType;
import NinethLectureObjectCommunication.logger.interfaces.Handler;

public abstract class Logger implements Handler {
    private Handler handler;

   @Override
   public void setSuccessor(Handler handler){
     this.handler = handler;
   }

   protected void passToSuccessor(LogType logType, String message){
       if (this.handler != null){
           this.handler.handle(logType,message);
       }
   }
}
