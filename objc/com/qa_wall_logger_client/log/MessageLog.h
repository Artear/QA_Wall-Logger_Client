//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: src/main/java/com/qa_wall_logger_client/log/MessageLog.java
//

#ifndef _QA_Wall_MessageLog_H_
#define _QA_Wall_MessageLog_H_

@protocol JavaUtilList;

#include "J2ObjC_header.h"
#include "com/qa_wall_logger_client/log/Log.h"

@interface QA_Wall_MessageLog : NSObject < QA_Wall_Log > {
}

/**
 @param logMsg a message to identify the com.qa_wall_logger_client.log
 */
- (instancetype)initWithLong:(jlong)time
                withNSString:(NSString *)logMsg;

- (id<JavaUtilList>)getUrlPaths;

- (jlong)getTime;

- (NSString *)getLogMsg;

@end

J2OBJC_EMPTY_STATIC_INIT(QA_Wall_MessageLog)

CF_EXTERN_C_BEGIN
CF_EXTERN_C_END

typedef QA_Wall_MessageLog ComQa_wall_logger_clientLogMessageLog;

J2OBJC_TYPE_LITERAL_HEADER(QA_Wall_MessageLog)

#endif // _QA_Wall_MessageLog_H_
