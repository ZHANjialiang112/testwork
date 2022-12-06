//package com.comment.utils.compare;
//
//import lombok.AccessLevel;
//import lombok.NoArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.lang.NonNull;
//import org.springframework.lang.Nullable;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.ParsePosition;
//import java.text.SimpleDateFormat;
//import java.time.*;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//import java.util.regex.Pattern;
//
///**
// * @description: 日期工具类
// **/
//@Slf4j
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
//public final class DateUtils {
//
//    public final static String NOT_SEPARATOR_DATE = "yyyyMMdd";
//
//    public final static String NOT_SEPARATOR_DATE_TIME = "yyyyMMddHHmmss";
//
//    public final static String HAS_SEPARATOR_DATE = "yyyy-MM-dd";
//
//    public final static String HAS_SEPARATOR_SOLIDUS_DATE = "yyyy/MM/dd";
//
//    public final static String NOT_SEPARATOR_TIME = "HHmmss";
//
//    public final static String NOT_SEPARATOR_YEAR_MONTH = "yyyyMM";
//
//    public final static String HAS_SEPARATOR_YEAR_MONTH = "yyyy-MM";
//
//    public final static String CHINESE_DATE = "yyyy年MM月dd日";
//
//    public final static String HAS_SEPARATOR_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
//
//    public final static String HAS_SEPARATOR_DATE_HOUR_MINUTE = "yyyy-MM-dd HH:mm";
//
//    public final static String HAS_SEPARATOR_DATE_HOUR = "yyyy-MM-dd HH";
//
//    public final static String HAS_SEPARATOR_FULL_DATE_TIME = "yyyy-MM-dd HH:mm:ss.SSS";
//
//
//    public final static DateTimeFormatter LOCAL_DATE_FORMATTER;
//    static {
//        LOCAL_DATE_FORMATTER = DateTimeFormatter.ofPattern(HAS_SEPARATOR_DATE);
//    }
//
//    public final static DateTimeFormatter LOCAL_DATE_TIME_FORMATTER;
//    static {
//        LOCAL_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(HAS_SEPARATOR_DATE_TIME);
//    }
//
//    public final static String GMT_8 = "GMT+8";
//
//    public static final String TIME_SEPARATOR_SYMBOL = ":";
//    public static final String STRIGULA_SEPARATOR_SYMBOL = "-";
//
//    public static long ONE_DAY_MILL_SECONDS = 86400000;
//
//    public final static long ONE_DAY_SECONDS = 86400;
//
//    public static Date getNowDate() {
//        return new Date();
//    }
//
//    public static Date getDate(long millisecond) {
//        return new Date(millisecond);
//    }
//
//    public static DateFormat getNewDateFormat(String pattern) {
//        DateFormat df = new SimpleDateFormat(pattern);
//        df.setLenient(false);
//        return df;
//    }
//
//    public static DateTimeFormatter getNewDateTimeFormatter(String pattern) {
//        return DateTimeFormatter.ofPattern(pattern);
//    }
//
//    //日期格式转换，返回日期类型
//    public static Date formatDate(Date date, String format) {
//        SimpleDateFormat formatter = new SimpleDateFormat(format);
//        String dateString = formatter.format(date);
//        ParsePosition pos = new ParsePosition(0);
//        return formatter.parse(dateString, pos);
//    }
//
//    /**
//     * 将 String 转换成 Date
//     *
//     * @param date yyyy-MM-dd
//     * @return Date
//     */
//    public static Date parseStringToDate(String date) {
//        if (StringUtils.isBlank(date)) {
//            return null;
//        }
//        DateFormat df = getNewDateFormat(HAS_SEPARATOR_DATE);
//        try {
//            return df.parse(date.replace("/","-"));
//        } catch (ParseException e) {
//            throw new BusinessException(CodeMsg.DATE_FORMAT_ERROR.fillArgs(date));
//        }
//    }
//
//    public static Date parseStringMultiFormatToDate(String date) {
//        if (StringUtils.isBlank(date)) {
//            return null;
//        }
//        String[] possibleDateFormats =
//                {
//                        HAS_SEPARATOR_DATE,
//                        NOT_SEPARATOR_DATE,
//                        CHINESE_DATE,
//                        HAS_SEPARATOR_SOLIDUS_DATE,
//                        HAS_SEPARATOR_FULL_DATE_TIME
//                };
//        try {
//            return org.apache.commons.lang3.time.DateUtils.parseDate(date, possibleDateFormats);
//        } catch (ParseException e) {
//            throw new BusinessException(CodeMsg.DATE_FORMAT_ERROR.fillArgs(date));
//        }
//    }
//
//    /**
//     * 将 String 转换成 DateTime
//     *
//     * @param date yyyy-MM-dd HH:mm:ss
//     * @return Date
//     */
//    public static Date parseStringToDateTime(String date) {
//        if (StringUtils.isBlank(date)) {
//            return null;
//        }
//        DateFormat df = getNewDateFormat(HAS_SEPARATOR_DATE_TIME);
//        try {
//            return df.parse(date.replace("/","-"));
//        } catch (ParseException e) {
//            throw new BusinessException(CodeMsg.DATE_FORMAT_ERROR.fillArgs(date));
//        }
//    }
//
//    /**
//     * 将 String 转换成 LocalDate
//     *
//     * @param date yyyy-MM-dd
//     * @return LocalDate
//     */
//    public static LocalDate parseStringToLocalDate(String date) {
//        if (StringUtils.isBlank(date)) {
//            return null;
//        }
//        Date stringToDate = parseStringToDate(date);
//        return dateToLocalDate(stringToDate);
//    }
//
//    /**
//     * 将 String 转换成 LocalDateTime
//     *
//     * @param date yyyy-MM-dd HH:mm:ss 或 yyyy-MM-dd HH:mm
//     * @return LocalDateTime
//     */
//    public static LocalDateTime parseStringToLocalDateTime(String date) {
//        if (StringUtils.isBlank(date)) {
//            return null;
//        }
//        if (date.split(TIME_SEPARATOR_SYMBOL).length != 3) {
//            date = date + ":00";
//        }
//        Date dateTime = parseStringToDateTime(date);
//        return dateToLocalDateTime(dateTime);
//    }
//
//    /**
//     * 将 Date 类型格式化成有 "-" 分隔符的 String 类型
//     *
//     * @param date 需要格式化日期
//     * @return yyyy-MM
//     */
//    public static String formatHasSeparatorYearMonth(Date date) {
//        if (Objects.isNull(date)) {
//            return "";
//        }
//        return getNewDateFormat(HAS_SEPARATOR_YEAR_MONTH).format(date);
//    }
//
//    /**
//     * 将 Date 类型格式化成有 "-" 分隔符的 String 类型
//     *
//     * @param date 需要格式化日期
//     * @return yyyy-MM-dd
//     */
//    public static String formatHasSeparatorDate(Date date) {
//        if (Objects.isNull(date)) {
//            return "";
//        }
//        return getNewDateFormat(HAS_SEPARATOR_DATE).format(date);
//    }
//
//    /**
//     * 将 Date 类型格式化成有 "-" 分隔符的 String 类型
//     *
//     * @param date 需要格式化日期
//     * @return yyyy-MM-dd HH:mm:ss
//     */
//    public static String formatHasSeparatorDateTime(Date date) {
//        if (Objects.isNull(date)) {
//            return "";
//        }
//        return getNewDateFormat(HAS_SEPARATOR_DATE_TIME).format(date);
//    }
//
//    /**
//     * 将 LocalDateTime 类型格式化成有 "-" 分隔符的 String 类型
//     *
//     * @param date 需要格式化日期
//     * @return yyyy-MM-dd
//     */
//    public static String formatHasSeparatorDate(LocalDateTime date) {
//        if (Objects.isNull(date)) {
//            return null;
//        }
//        return getNewDateTimeFormatter(HAS_SEPARATOR_DATE).format(date);
//    }
//
//    /**
//     * 将 LocalDateTime 类型格式化成有 "-" 分隔符的 String 类型
//     *
//     * @param date 需要格式化日期
//     * @return yyyy-MM-dd HH:mm:ss
//     */
//    public static String formatHasSeparatorDateTime(LocalDateTime date) {
//        if (Objects.isNull(date)) {
//            return null;
//        }
//        return getNewDateTimeFormatter(HAS_SEPARATOR_DATE_TIME).format(date);
//    }
//
//    /**
//     * 将 LocalDateTime 类型格式化成有 "-" 分隔符的 String 类型
//     *
//     * @param date 需要格式化日期
//     * @return yyyy-MM-dd HH:mm
//     */
//    public static String formatHasSeparatorDateHourMinute(LocalDateTime date) {
//        if (Objects.isNull(date)) {
//            return null;
//        }
//        return getNewDateTimeFormatter(HAS_SEPARATOR_DATE_HOUR_MINUTE).format(date);
//    }
//
//    /**
//     * 将 LocalDate 类型格式化成有 "-" 分隔符的 String 类型
//     *
//     * @param date 需要格式化日期
//     * @return yyyy-MM
//     */
//    public static String formatHasSeparatorYearMonth(LocalDate date) {
//        if (Objects.isNull(date)) {
//            return null;
//        }
//        return getNewDateTimeFormatter(HAS_SEPARATOR_YEAR_MONTH).format(date);
//    }
//
//    /**
//     * 构建 yyyy-MM 的当前年月的开始日期
//     *
//     * @param yyyy_MM 日期格式为 yyyy-MM String 类型
//     * @return Date
//     */
//    public static Date buildStartDateByYearAndMonth(String yyyy_MM) {
//        buildDateByYearAndMonthFormatValidation(yyyy_MM);
//        String[] yyyyMMs = yyyy_MM.split("-");
//        String yyyy = yyyyMMs[0];
//        String mm = yyyyMMs[1];
//
//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.YEAR, Integer.parseInt(yyyy));
//        cal.set(Calendar.MONTH, Integer.parseInt(mm) - 1);
//        cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
//        log.info("buildStartDateByYearAndMonth: " + DateUtils.formatHasSeparatorDate(cal.getTime()));
//        return cal.getTime();
//    }
//
//    /**
//     * 构建 yyyy-MM 的当前年月的结束日期
//     *
//     * @param yyyy_MM 日期格式为 yyyy-MM String 类型
//     * @return Date
//     */
//    public static Date buildEndDateByYearAndMonth(String yyyy_MM) {
//        if(Objects.nonNull(yyyy_MM)){
//            yyyy_MM = yyyy_MM.replaceAll("/","-");
//        }
//        buildDateByYearAndMonthFormatValidation(yyyy_MM);
//        String[] yyyyMMs = yyyy_MM.split("-");
//        String yyyy = yyyyMMs[0];
//        String mm = yyyyMMs[1];
//
//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.YEAR, Integer.parseInt(yyyy));
//        cal.set(Calendar.MONTH, Integer.parseInt(mm) - 1);
//        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
//        log.info("buildEndDateByYearAndMonth: " + DateUtils.formatHasSeparatorDate(cal.getTime()));
//        return cal.getTime();
//    }
//
//    private static void buildDateByYearAndMonthFormatValidation(String yyyy_MM) {
//        if (StringUtils.isBlank(yyyy_MM)) {
//            throw new BusinessException(UtilErrorCodeMsg.PARAM_IS_NULL.fillArgs("日期格式转换失败"));
//        }
//        if (!yyyy_MM.contains("-")) {
//            throw new BusinessException(UtilErrorCodeMsg.DATE_FORMAT_ERROR.fillArgs(yyyy_MM));
//        }
//        if (yyyy_MM.split("-").length != 2) {
//            throw new BusinessException(UtilErrorCodeMsg.DATE_FORMAT_ERROR.fillArgs(yyyy_MM));
//        }
//    }
//
//    /**
//     * 获取两个 date 的 Period
//     *
//     * @param begin 开始日期
//     * @param end   结束日期
//     * @return Period
//     */
//    public static Period getTwoDatePeriod(Date begin, Date end) {
//        Calendar calBegin = Calendar.getInstance();
//        calBegin.setTime(begin);
//        Calendar calEnd = Calendar.getInstance();
//        calEnd.setTime(end);
//        return getTwoLocalDatePeriod(
//                LocalDate.of(
//                        calBegin.get(Calendar.YEAR),
//                        calBegin.get(Calendar.MONTH) + 1,
//                        calBegin.get(Calendar.DAY_OF_MONTH)
//                ),
//                LocalDate.of(
//                        calEnd.get(Calendar.YEAR),
//                        calEnd.get(Calendar.MONTH) + 1,
//                        calEnd.get(Calendar.DAY_OF_MONTH)
//                )
//        );
//    }
//
//    /**
//     * 获取两个 date 之间格式为 'yyyy-MM' 的年月集合
//     * 注：包含开始、结束日期的 'yyyy-MM'
//     *
//     * @param begin 开始日期
//     * @param end   结束日期
//     * @return Period
//     */
//    public static Period getTwoLocalDatePeriod(LocalDate begin, LocalDate end) {
//        return Period.between(begin, end);
//    }
//
//    public static List<String> getYearMonthBetweenBeginAndEnd(LocalDate begin, LocalDate end) {
//        Period period = getTwoLocalDatePeriod(begin, end);
//        int months = period.getMonths();
//        List<String> yearMonths = new ArrayList<>(months);
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(localDate2Date(begin));
//        for (int i = 0; i <= months; i++) {
//            yearMonths.add(DateUtils.formatHasSeparatorYearMonth(cal.getTime()));
//            cal.add(Calendar.MONTH, 1);
//        }
//        return yearMonths;
//    }
//
//    /**
//     * 可能出现空指针异常
//     * @param date
//     * @return
//     * @see DateUtils#convertLocalDate(LocalDate)
//     */
//    public static Date localDate2Date(@NonNull LocalDate date) {
//        ZonedDateTime zonedDateTime = date.atStartOfDay(ZoneId.systemDefault());
//        return Date.from(zonedDateTime.toInstant());
//    }
//
//    /**
//     * Date to LocalDateTime
//     *
//     * @param date 需要转换的日期对象
//     * @return LocalDateTime
//     */
//    public static LocalDateTime dateToLocalDateTime(Date date) {
//        if (Objects.isNull(date)) {
//            throw new BusinessException(UtilErrorCodeMsg.PARAM_IS_NULL.fillArgs("日期转换失败!"));
//        }
//        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
//    }
//
//    public static LocalDate dateToLocalDate(Date date) {
//        if (Objects.isNull(date)) {
//            throw new BusinessException(UtilErrorCodeMsg.PARAM_IS_NULL.fillArgs("日期转换失败!"));
//        }
//        Instant instant = date.toInstant();
//        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
//    }
//
//    /**
//     * 根据"yyyy-MM-dd"格式字符串构建日期
//     *
//     * @param yyyy_MM_dd yyyy-MM-dd
//     * @param dayStart   若 null, 则时分秒不处理；若 true，则时分秒处理成一天的开始；否则时分秒处理成一天的结束
//     * @return Date
//     */
//    public static Date buildDateTimeFromString(String yyyy_MM_dd, Boolean dayStart) {
//        if (StringUtils.isBlank(yyyy_MM_dd)) {
//            return null;
//        }
//        yyyy_MM_dd = yyyy_MM_dd.replaceAll("/","-");
//        String[] yyyyMMdd = yyyy_MM_dd.split(STRIGULA_SEPARATOR_SYMBOL);
//        if (yyyyMMdd.length != 3) {
//            throw new BusinessException(UtilErrorCodeMsg.DATE_FORMAT_ERROR.fillArgs(yyyy_MM_dd));
//        }
//        try {
//            int yyyy = Integer.parseInt(yyyyMMdd[0]);
//            int mm = Integer.parseInt(yyyyMMdd[1]);
//            int dd = Integer.parseInt(yyyyMMdd[2]);
//            Calendar cal = Calendar.getInstance();
//            cal.set(Calendar.YEAR, yyyy);
//            // 月份是从0开始的
//            cal.set(Calendar.MONTH, mm - 1);
//            cal.set(Calendar.DAY_OF_MONTH, dd);
//            if (Objects.isNull(dayStart)) {
//                return cal.getTime();
//            }
//            if (dayStart) {
//                cal.set(Calendar.HOUR_OF_DAY, 0);
//                cal.set(Calendar.MINUTE, 0);
//                cal.set(Calendar.SECOND, 0);
//                cal.set(Calendar.MILLISECOND, 0);
//            } else {
//                cal.set(Calendar.HOUR_OF_DAY, 23);
//                cal.set(Calendar.MINUTE, 59);
//                cal.set(Calendar.SECOND, 59);
//            }
//            log.debug("buildDateTimeFromString: " + formatHasSeparatorDateTime(cal.getTime()));
//            return cal.getTime();
//        } catch (NumberFormatException e) {
//            throw new BusinessException(UtilErrorCodeMsg.PARAM_FORMAT_ERROR.fillArgs("日期格式转换失败"));
//        }
//    }
//
//    public static Date buildDateTimeFromYYYYMM(String yyyy_MM, Boolean dayStart) {
//        if (StringUtils.isBlank(yyyy_MM)) {
//            return null;
//        }
//        yyyy_MM = yyyy_MM.replaceAll("/","-");
//        String[] yyyyMM = yyyy_MM.split(STRIGULA_SEPARATOR_SYMBOL);
//        if (yyyyMM.length != 2) {
//            throw new BusinessException(UtilErrorCodeMsg.DATE_FORMAT_ERROR.fillArgs(yyyy_MM));
//        }
//        try {
//            int yyyy = Integer.parseInt(yyyyMM[0]);
//            int mm = Integer.parseInt(yyyyMM[1]);
//            Calendar cal = Calendar.getInstance();
//            cal.set(Calendar.YEAR, yyyy);
//            // 月份是从0开始的
//            cal.set(Calendar.MONTH, mm - 1);
//            if (Objects.isNull(dayStart)) {
//                cal.set(Calendar.DAY_OF_MONTH, 1);
//                return cal.getTime();
//            }
//            if (dayStart) {
//                cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
//                cal.set(Calendar.HOUR_OF_DAY, 0);
//                cal.set(Calendar.MINUTE, 0);
//                cal.set(Calendar.SECOND, 0);
//            } else {
//                cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
//                cal.set(Calendar.HOUR_OF_DAY, 23);
//                cal.set(Calendar.MINUTE, 59);
//                cal.set(Calendar.SECOND, 59);
//            }
//            log.debug("buildDateTimeFromString: " + formatHasSeparatorDateTime(cal.getTime()));
//            return cal.getTime();
//        } catch (NumberFormatException e) {
//            throw new BusinessException(UtilErrorCodeMsg.PARAM_FORMAT_ERROR.fillArgs("日期格式转换失败!"));
//        }
//    }
//
//    /**
//     * 以天为单位，计算日期
//     *
//     * @param date 时间
//     * @param day  移动的天数
//     * @return Date
//     */
//    public static Date moveTime(Date date, int day) {
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(date);
//        //把日期往后增加一天.整数往后推,负数往前移动
//        calendar.add(Calendar.DATE, day);
//        //这个时间就是日期往后推一天的结果
//        return calendar.getTime();
//    }
//
//
//    /**
//     * 以月为单位，计算日期
//     *
//     * @param date 时间
//     * @param month  移动的月数
//     * @return Date 返回移动后的时间
//     */
//    public static Date moveMonth(Date date, int month) {
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(date);
//        //把日期往后增加一月.整数往后推,负数往前移动
//        calendar.add(Calendar.MONTH, month);
//        //这个时间就是日期往后推一天的结果
//        return calendar.getTime();
//    }
//
//    /**
//     * 将DateTime转换成Date
//     *
//     * @param date 需要转换的日期
//     * @return Date
//     */
//    public static Date transformDateTimeToDate(Date date) {
//        if (Objects.isNull(date)) {
//            throw new BusinessException(UtilErrorCodeMsg.PARAM_IS_NULL.fillArgs("日期格式转换失败"));
//        }
//        return parseStringToDate(formatHasSeparatorDate(date));
//    }
//
//    public static boolean dateStrCompareToNow(String date) {
//        if (StringUtils.isBlank(date)) {
//            return false;
//        }
//        date = date.replaceAll("/","-");
//        String[] dates = date.split(STRIGULA_SEPARATOR_SYMBOL);
//        String year = null;
//        String month = null;
//        String day = null;
//        if (dates.length == 3) {
//            year = dates[0];
//            month = dates[1];
//            day = dates[2];
//        }
//        if (dates.length == 2) {
//            year = dates[0];
//            month = dates[1];
//        }
//        if (StringUtils.isNotBlank(year) && StringUtils.isNotBlank(month)) {
//            Calendar calendar = Calendar.getInstance();
//            calendar.set(Calendar.YEAR, Integer.parseInt(year));
//            calendar.set(Calendar.MONTH, Integer.parseInt(month));
//            if (StringUtils.isNotBlank(day)) {
//                calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
//            }
//            return calendar.getTime().getTime() > System.currentTimeMillis();
//        }
//        return false;
//    }
//
//    // ---------------------------------------------------------------------
//
//    public static LocalDate parseLocalDate(String str) {
//        if (!StringUtils.isEmpty(str)) {
//            try {
//                str = str.replace("/","-");
//                if(str.length()>10){
//                    str = str.substring(0,10);
//                }
//                return LocalDate.parse(str, DateUtils.LOCAL_DATE_FORMATTER);
//            } catch (Exception e) {
//                try {
//                    return DateUtils.dateToLocalDate(DateUtils.parseStringMultiFormatToDate(str));
//                } catch (Exception ex) {
//                    log.error(ex.getMessage(),ex);
//                    throw new ServiceException("不符合时间格式:"+str +"转为" + DateUtils.HAS_SEPARATOR_DATE);
//                }
//            }
//        }
//        return null;
//    }
//
//    public static LocalDateTime parseLocalDateTime(String str) {
//        if (!StringUtils.isEmpty(str)) {
//            try {
//                str = str.replaceAll("/","-");
//                return LocalDateTime.parse(str, DateUtils.LOCAL_DATE_TIME_FORMATTER);
//            } catch (Exception e) {
//                try {
//                    return DateUtils.dateToLocalDateTime(DateUtils.parseStringMultiFormatToDate(str));
//                } catch (Exception ex) {
//                    log.error(ex.getMessage(),ex);
//                    throw new ServiceException("不符合时间格式:" + DateUtils.HAS_SEPARATOR_DATE_TIME);
//                }
//            }
//        }
//        return null;
//    }
//
//    public static Optional<LocalDate> parseLocaDataOptional(String str) {
//        if (!StringUtils.isEmpty(str)) {
//            try {
//                str = str.replaceAll("/","-");
//                return Optional.of(LocalDate.parse(str, DateUtils.LOCAL_DATE_FORMATTER));
//            } catch (Exception e) {
//            }
//        }
//        return Optional.empty();
//    }
//
//    public static Optional<LocalDateTime> parseLocaDataTimeOptional(String str) {
//        if (!StringUtils.isEmpty(str)) {
//            try {
//                str = str.replaceAll("/","-");
//                return Optional.of(LocalDateTime.parse(str, DateUtils.LOCAL_DATE_TIME_FORMATTER));
//            } catch (Exception e) {
//            }
//        }
//        return Optional.empty();
//    }
//
//    public static String formatLocaData(LocalDate date) {
//        if (Objects.nonNull(date)) {
//            return date.format(LOCAL_DATE_FORMATTER);
//        }
//        return null;
//    }
//
//    public static String formatLocaDataTime(LocalDateTime dateTime) {
//        if (Objects.nonNull(dateTime)) {
//            return LOCAL_DATE_FORMATTER.format(dateTime);
//        }
//        return null;
//    }
//
//
//    /**
//     * 将字符串转成时间
//     * 支持 yyyy-MM-dd  或者 yyyy-MM-dd HH:mm:ss
//     * 对于月、天、时、分、秒为个位数的进行补零操作
//     * @param str 时间的字符串
//     */
//    public static Optional<LocalDateTime> parseLocalDataTimeCompletion(String str) {
//        if (!StringUtils.isEmpty(str)) {
//            str = complementDateStr(str);
//            if(RegexUtils.validateRegexp(RegexUtils.DATE, str)){
//                str += " 00:00:00";
//            }
//            try {
//                return Optional.of(LocalDateTime.parse(str, DateUtils.LOCAL_DATE_TIME_FORMATTER));
//            } catch (Exception ignored) {
//            }
//        }
//        return Optional.empty();
//    }
//
//    /**
//     * 补全字符串
//     * 先补全数据，yyyy-M-d 补全为 yyyy-MM-dd 。H:m:s 补全为HH:mm:ss
//     */
//    public static String complementDateStr(String dateStr){
//        dateStr = dateStr.replaceAll("/", "-").trim();
//        if(StringUtils.isBlank(dateStr)){
//            return dateStr;
//        }
//        String[] dateStrArr = dateStr.split(" ");
//        String orgDateS = "";
//        String orgTimeS = "";
//        String dateS = "";
//        String timeS = "";
//        if(dateStrArr.length == 1){
//            orgDateS = dateStrArr[0];
//        } else if (dateStrArr.length == 2) {
//            orgDateS = dateStrArr[0];
//            orgTimeS = dateStrArr[1];
//        }
//
//        if(StringUtils.isNotBlank(orgDateS)){
//            if(orgDateS.length() == 10){
//                dateS = dateStrArr[0]; // 年月日
//            } else if(orgDateS.length() < 10){
//                String[] split = orgDateS.split("-");
//                dateS += split[0] + "-";
//                if(split[1].length() == 1){
//                    dateS += "0"; // 不足2位进行补0
//                }
//                dateS += split[1] + "-";
//                if(split[2].length() == 1){
//                    dateS += "0";
//                }
//                dateS += split[2];
//            }
//        }
//        if(StringUtils.isNotBlank(orgTimeS)) {
//            if(orgTimeS.length() == 8){
//                timeS = dateStrArr[1];
//            } else if(orgTimeS.length() < 8){
//                String[] split = orgTimeS.split(":");
//                if(split[0].length() == 1){
//                    timeS += "0";
//                }
//                timeS += split[0] + ":";
//                if(split[1].length() == 1){
//                    timeS += "0";
//                }
//                timeS += split[1] + ":";
//                if(split[2].length() == 1){
//                    timeS += "0";
//                }
//                timeS += split[2];
//            }
//        }
//
//        return (dateS + " " + timeS).trim();
//    }
//
//
//    /**
//    * 谨慎使用
//    * @author   koujiang
//    * @param	date    待转换的时间
//    * @return   java.time.LocalDate
//    * @since    2022/2/12 12:54 下午
//    */
//    @Nullable
//    public static LocalDate parseLocalDate(@Nullable Date date) {
//        if (Objects.nonNull(date)) {
//            return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
//        }
//        return null;
//    }
//
//    /**
//    * 谨慎使用
//    * @author   koujiang
//    * @param	date    待转换的时间
//    * @return   java.time.LocalDateTime
//    * @since    2022/2/12 1:02 下午
//    */
//    @Nullable
//    public static LocalDateTime parseLocalDateTime(@Nullable Date date) {
//        if (Objects.nonNull(date)) {
//            return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
//        }
//        return null;
//    }
//
//    /**
//    * 谨慎使用
//    * @author   koujiang
//    * @param	localDate   待转换的时间
//    * @return   java.util.Date
//    * @since    2022/2/12 1:02 下午
//    */
//    @Nullable
//    public static Date convertLocalDate(@Nullable LocalDate localDate) {
//        if (Objects.nonNull(localDate)) {
//            return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
//        }
//        return null;
//    }
//
//    /**
//    * 谨慎使用
//    * @author   koujiang
//    * @param	localDateTime   待转换的时间
//    * @return   java.util.Date
//    * @since    2022/2/12 1:01 下午
//    */
//    @Nullable
//    public static Date convertLocalDateTime(@Nullable LocalDateTime localDateTime) {
//        if (Objects.nonNull(localDateTime)) {
//            return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
//        }
//        return null;
//    }
//
//    /**判断日期格式 支持yyyy-MM-dd, yyyy/MM/dd, yyyy.MM.dd **/
//    private static String DATE_REGEX1 = "^([1-9]\\d{3}[-/.])(([0]{0,1}[1-9][-/.])|([1][0-2][-/.]))(([0-3]{0,1}[0-9]))$";
//   /**判断日期格式 支持 yyyyMMdd **/
//    private static String DATE_REGEX2 = "^([1-9]\\d{3})(([0][1-9])|([1][0-2]))([0-3][0-9])$";
//
//    /***
//     * @desc 校验日期的格式，yyyy-MM-dd，
//     * @param datestr：日期，格式：yyyy-MM-dd或yyyy/MM/dd 或 yyyyMMdd
//     * @return boolean
//     */
//    public static boolean validDateEffecitive(String datestr) throws Exception{
//        boolean matches1 =  Pattern.matches(DATE_REGEX1, datestr);
//        boolean matches2 =  Pattern.matches(DATE_REGEX2, datestr);
//        if(!matches1 && !matches2){
//            return false;
//        }
//        // todo if(StringUtils.isBlank(datestr)){}
//        SimpleDateFormat sdf;
//        if(matches1) {
//             sdf = new SimpleDateFormat(HAS_SEPARATOR_DATE);
//            //设置日期格式转的严谨性
//            sdf.setLenient(false);
//            try {
//                sdf.parse(datestr.replaceAll("/","-").replaceAll("\\.","-"));
//            } catch (ParseException e) {
//                log.error("日期格式转换异常", e);
//                return false;
//            }
//            return true;
//        }else {
//            sdf = new SimpleDateFormat(NOT_SEPARATOR_DATE);
//            //设置日期格式转的严谨性
//            sdf.setLenient(false);
//            try {
//                sdf.parse(datestr);
//            } catch (ParseException e) {
//                log.error("日期格式转换异常", e);
//                return false;
//            }
//            return true;
//        }
//
//    }
//
//    /**
//    * 将时间转换成:yyyy-MM-dd格式
//    * @author   koujiang
//    * @param	date        待转换的时间
//    * @return   java.lang.String
//    * @since    2022/3/9 7:11 下午
//    */
//    @Nullable
//    public static String format(LocalDate date) {
//        if (Objects.nonNull(date)) {
//            return date.format(LOCAL_DATE_FORMATTER);
//        }
//        return null;
//    }
//
//    /**
//    * 将时间转换成:yyyy-MM-dd HH:mm:ss格式
//    * @author   koujiang
//    * @param	dateTime    待转换的时间
//    * @return   java.lang.String
//    * @since    2022/3/9 7:11 下午
//    */
//    @Nullable
//    public static String format(LocalDateTime dateTime) {
//        if (Objects.nonNull(dateTime)) {
//            return dateTime.format(LOCAL_DATE_TIME_FORMATTER);
//        }
//        return null;
//    }
//
//    /**
//     * LocalDate转为LocalDateTime
//     * @author sky
//     * @param localDate 待转换的日期
//     * @param localTime 需要增加的时分秒
//     * @return 转换后的日期
//     */
//    public static LocalDateTime localDate2LocalDateTime(LocalDate localDate,LocalTime localTime){
//        LocalDateTime localDateTime = null;
//        if(!Objects.isNull(localDate) && !Objects.isNull(localTime)){
//            localDateTime = LocalDateTime.of(localDate,localTime);
//        }
//        return localDateTime;
//    }
//
//    /**
//     * 是否在时间段内
//     * @param startDate 开始时间
//     * @param endDate 结束时间
//     * @param nowDate 当前时间
//     * @return true在时间段内，false不在时间段内
//     */
//    public static boolean isInDate(Date startDate,Date endDate,Date nowDate) {
//        if(Objects.isNull(startDate) || Objects.isNull(endDate) || Objects.isNull(nowDate)) {
//            return  false;
//        }
//        LocalDateTime startDateTime = DateUtils.dateToLocalDateTime(startDate);
//        LocalDateTime endDateTime = DateUtils.dateToLocalDateTime(endDate);
//        LocalDateTime nowDateTime = DateUtils.dateToLocalDateTime(nowDate);
//        return nowDateTime.isAfter(startDateTime) && nowDateTime.isBefore(endDateTime);
//    }
//
//}
