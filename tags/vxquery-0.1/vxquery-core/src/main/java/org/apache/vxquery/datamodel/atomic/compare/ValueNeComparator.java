/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.apache.vxquery.datamodel.atomic.compare;

import org.apache.vxquery.collations.Collation;
import org.apache.vxquery.datamodel.atomic.Base64BinaryValue;
import org.apache.vxquery.datamodel.atomic.BooleanValue;
import org.apache.vxquery.datamodel.atomic.DateTimeValue;
import org.apache.vxquery.datamodel.atomic.DateValue;
import org.apache.vxquery.datamodel.atomic.DurationValue;
import org.apache.vxquery.datamodel.atomic.GDayValue;
import org.apache.vxquery.datamodel.atomic.GMonthDayValue;
import org.apache.vxquery.datamodel.atomic.GMonthValue;
import org.apache.vxquery.datamodel.atomic.GYearMonthValue;
import org.apache.vxquery.datamodel.atomic.GYearValue;
import org.apache.vxquery.datamodel.atomic.HexBinaryValue;
import org.apache.vxquery.datamodel.atomic.NumericValue;
import org.apache.vxquery.datamodel.atomic.QNameValue;
import org.apache.vxquery.datamodel.atomic.StringValue;
import org.apache.vxquery.datamodel.atomic.TimeValue;
import org.apache.vxquery.exceptions.SystemException;

public final class ValueNeComparator implements ValueComparator {
    public static final ValueComparator INSTANCE = new ValueNeComparator();

    private ValueNeComparator() {
    }

    @Override
    public boolean compareBoolean(BooleanValue v1, BooleanValue v2) throws SystemException {
        return v1.getBooleanValue() != v2.getBooleanValue();
    }

    @Override
    public boolean compareDate(DateValue v1, DateValue v2, int implicitTZ) throws SystemException {
        return !ValueEqComparator.INSTANCE.compareDate(v1, v2, implicitTZ);
    }

    @Override
    public boolean compareDateTime(DateTimeValue v1, DateTimeValue v2, int implicitTZ) throws SystemException {
        return !ValueEqComparator.INSTANCE.compareDateTime(v1, v2, implicitTZ);
    }

    @Override
    public boolean compareDecimal(NumericValue v1, NumericValue v2) throws SystemException {
        return !v1.getDecimalValue().equals(v2.getDecimalValue());
    }

    @Override
    public boolean compareDouble(NumericValue v1, NumericValue v2) throws SystemException {
        return v1.getDoubleValue() != v2.getDoubleValue();
    }

    @Override
    public boolean compareDuration(DurationValue v1, DurationValue v2) throws SystemException {
        return !v1.equals(v2);
    }

    @Override
    public boolean compareFloat(NumericValue v1, NumericValue v2) throws SystemException {
        return v1.getFloatValue() != v2.getFloatValue();
    }

    @Override
    public boolean compareInteger(NumericValue v1, NumericValue v2) throws SystemException {
        return !v1.getIntegerValue().equals(v2.getIntegerValue());
    }

    @Override
    public boolean compareQName(QNameValue v1, QNameValue v2) throws SystemException {
        return v1.getNameCache() != v2.getNameCache() && v1.getCode() == v2.getCode();
    }

    @Override
    public boolean compareString(StringValue v1, StringValue v2, Collation collation) throws SystemException {
        return collation.getComparator().compare(v1.getStringValue(), v2.getStringValue()) != 0;
    }

    @Override
    public boolean compareTime(TimeValue v1, TimeValue v2, int implicitTZ) throws SystemException {
        return !ValueEqComparator.INSTANCE.compareTime(v1, v2, implicitTZ);
    }

    @Override
    public boolean compareBase64Binary(Base64BinaryValue v1, Base64BinaryValue v2) throws SystemException {
        return !ValueEqComparator.INSTANCE.compareBase64Binary(v1, v2);
    }

    @Override
    public boolean compareGDay(GDayValue v1, GDayValue v2, int implicitTZ) throws SystemException {
        return !ValueEqComparator.INSTANCE.compareGDay(v1, v2, implicitTZ);
    }

    @Override
    public boolean compareGMonth(GMonthValue v1, GMonthValue v2, int implicitTZ) throws SystemException {
        return !ValueEqComparator.INSTANCE.compareGMonth(v1, v2, implicitTZ);
    }

    @Override
    public boolean compareGMonthDay(GMonthDayValue v1, GMonthDayValue v2, int implicitTZ) throws SystemException {
        return !ValueEqComparator.INSTANCE.compareGMonthDay(v1, v2, implicitTZ);
    }

    @Override
    public boolean compareGYear(GYearValue v1, GYearValue v2, int implicitTZ) throws SystemException {
        return !ValueEqComparator.INSTANCE.compareGYear(v1, v2, implicitTZ);
    }

    @Override
    public boolean compareGYearMonth(GYearMonthValue v1, GYearMonthValue v2, int implicitTZ) throws SystemException {
        return !ValueEqComparator.INSTANCE.compareGYearMonth(v1, v2, implicitTZ);
    }

    @Override
    public boolean compareHexBinary(HexBinaryValue v1, HexBinaryValue v2) throws SystemException {
        return !ValueEqComparator.INSTANCE.compareHexBinary(v1, v2);
    }
}