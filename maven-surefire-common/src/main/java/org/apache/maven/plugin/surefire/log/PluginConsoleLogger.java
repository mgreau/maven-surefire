package org.apache.maven.plugin.surefire.log;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.surefire.log.api.ConsoleLogger;

/**
 * Wrapper logger of miscellaneous (Maven 2.2.1 or 3.1) implementations of {@link Log}.
 * Calling {@link Log#isInfoEnabled()} before {@link Log#info(CharSequence)} due to Maven 2.2.1.
 *
 * @author <a href="mailto:tibordigana@apache.org">Tibor Digana (tibor17)</a>
 * @since 2.20
 * @see ConsoleLogger
 */
public final class PluginConsoleLogger
    implements ConsoleLogger
{
    private final Log mojoLogger;

    public PluginConsoleLogger( Log mojoLogger )
    {
        this.mojoLogger = mojoLogger;
    }

    public boolean isDebugEnabled()
    {
        return mojoLogger.isDebugEnabled();
    }

    public void debug( String message )
    {
        if ( mojoLogger.isDebugEnabled() )
        {
            mojoLogger.debug( message );
        }
    }

    public void debug( CharSequence content, Throwable error )
    {
        if ( mojoLogger.isDebugEnabled() )
        {
            mojoLogger.debug( content, error );
        }
    }

    public boolean isInfoEnabled()
    {
        return mojoLogger.isInfoEnabled();
    }

    public void info( String message )
    {
        if ( mojoLogger.isInfoEnabled() )
        {
            mojoLogger.info( message );
        }
    }

    public boolean isWarnEnabled()
    {
        return mojoLogger.isWarnEnabled();
    }

    public void warning( String message )
    {
        if ( mojoLogger.isWarnEnabled() )
        {
            mojoLogger.warn( message );
        }
    }

    public void warning( CharSequence content, Throwable error )
    {
        if ( mojoLogger.isWarnEnabled() )
        {
            mojoLogger.warn( content, error );
        }
    }

    public boolean isErrorEnabled()
    {
        return mojoLogger.isErrorEnabled();
    }

    public void error( String message )
    {
        if ( mojoLogger.isErrorEnabled() )
        {
            mojoLogger.error( message );
        }
    }

    public void error( String message, Throwable t )
    {
        if ( mojoLogger.isErrorEnabled() )
        {
            mojoLogger.error( message, t );
        }
    }

    public void error( Throwable t )
    {
        if ( mojoLogger.isErrorEnabled() )
        {
            mojoLogger.error( t );
        }
    }
}
