package com.qa_wall_logger_client.log.log;

import java.util.List;

public interface Log
{
    /**
     * @return a list of url paths to the service, without any separator;
     */
    List<String> getUrlPaths();
}
