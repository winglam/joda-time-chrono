/*
 * Joda Software License, Version 1.0
 *
 *
 * Copyright (c) 2001-2004 Stephen Colebourne.  
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:  
 *       "This product includes software developed by the
 *        Joda project (http://www.joda.org/)."
 *    Alternately, this acknowledgment may appear in the software itself,
 *    if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The name "Joda" must not be used to endorse or promote products
 *    derived from this software without prior written permission. For
 *    written permission, please contact licence@joda.org.
 *
 * 5. Products derived from this software may not be called "Joda",
 *    nor may "Joda" appear in their name, without prior written
 *    permission of the Joda project.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE JODA AUTHORS OR THE PROJECT
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Joda project and was originally 
 * created by Stephen Colebourne <scolebourne@joda.org>. For more
 * information on the Joda project, please see <http://www.joda.org/>.
 */
package org.joda.time.format;

import org.joda.time.TimePeriod;
import org.joda.time.DurationType;
import org.joda.time.MutableTimePeriod;
import org.joda.time.ReadWritableTimePeriod;

/**
 * Defines an interface for parsing textual representations of time periods.
 *
 * @author Brian S O'Neill
 * @see TimePeriodFormatter
 * @see TimePeriodFormatterBuilder
 * @see TimePeriodFormat
 * @since 1.0
 */
public interface TimePeriodParser {

    /**
     * Parses a period from the given text, at the given position, saving the
     * result into the fields of the given ReadWritableDuration. If the parse
     * succeeds, the return value is the new text position. Note that the parse
     * may succeed without fully reading the text.
     * <p>
     * If it fails, the return value is negative, but the period may still be
     * modified. To determine the position where the parse failed, apply the
     * one's complement operator (~) on the return value.
     *
     * @param period  a period that will be modified
     * @param periodStr  text to parse
     * @param position position to start parsing from
     * @return new position, if negative, parse failed. Apply complement
     * operator (~) to get position of failure
     * @throws IllegalArgumentException if any field is out of range
     */
    int parseInto(ReadWritableTimePeriod period, String periodStr, int position);

    /**
     * Parses a period from the given text, returning a new TimePeriod.
     *
     * @param type  defines which fields may be parsed
     * @param periodStr  text to parse
     * @return parsed value in a Duration object
     * @throws IllegalArgumentException if any field is out of range
     */
    TimePeriod parseTimePeriod(DurationType type, String periodStr);

    /**
     * Parses a period from the given text, returning a new MutableTimePeriod.
     *
     * @param type  defines which fields may be parsed
     * @param periodStr  text to parse
     * @return parsed value in a MutableDuration object
     * @throws IllegalArgumentException if any field is out of range
     */
    MutableTimePeriod parseMutableTimePeriod(DurationType type, String periodStr);

}