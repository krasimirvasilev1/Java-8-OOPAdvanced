package NinethLectureObjectCommunication.observer.models.logger;

import NinethLectureObjectCommunication.observer.enums.LogType;
import NinethLectureObjectCommunication.observer.interfaces.Handler;

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
