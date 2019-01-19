PERSION_BID = {
    /**散标查询条件**/
    QUERY: {
        /**项目期限**/
        TERM: {
            /**所有，不限**/
            DEFAULT: {
                VALUE: 0
            },
            /**3个月以下**/
            SCOPE_OF_ONE: {
                VALUE: 1,
                MIN: 0,
                MAX: 3
            },
            /**3-6个月**/
            SCOPE_OF_TWO: {
                VALUE: 2,
                MIN: 3,
                MAX: 6
            },
            /**6-9个月**/
            SCOPE_OF_THREE: {
                VALUE: 3,
                MIN: 6,
                MAX: 9
            },
            /**9-12个月**/
            SCOPE_OF_FOUR: {
                VALUE: 4,
                MIN: 9,
                MAX: 12
            },
            /**12个月以上**/
            SCOPE_OF_FIVE: {
                VALUE: 5,
                MIN: 12
            }
        },
        /**参考年利率**/
        ANNUAL_RATE: {
            /**不限，默认**/
            DEFAULT: {
                VALUE: 0
            },
            /**0-8 8%以下**/
            SCOPE_OF_ONE: {
                VALUE: 1,
                MIN: 0,
                MAX: 8
            },
            /**8-10 8%-10% 年利率**/
            SCOPE_OF_TWO: {
                VALUE: 2,
                MIN: 8,
                MAX: 10
            },
            /**10-12 10%-12% 年利率**/
            SCOPE_OF_THREE: {
                VALUE: 3,
                MIN: 10,
                MAX: 12
            },
            /**12以上 12%以上 **/
            SCOPE_OF_FOUR: {
                VALUE: 4,
                MIN: 12
            },
        },
        /**还款方式**/
        REPAY_MODE: {
            /**不限，默认，不加条件**/
            DEFAULT: {
                VALUE: 0
            },
            /**等额本金**/
            SCOPE_OF_ONE: {
                VALUE: 1,
                TYPE: 1
            },
            /**等额本息**/
            SCOPE_OF_TWO: {
                VALUE: 2,
                TYPE: 2
            }
        },
        /**剩余金额**/
        LEFT_AMOUNT: {
            /**默认，不限，没有金额条件**/
            DEFAULT: {
                VALUE: 0
            },
            /**0-5000范围 5000以下**/
            SCOPE_OF_ONE: {
                VALUE: 1,
                MIN: 0,
                MAX: 5000
            },
            /**5000-20000**/
            SCOPE_OF_TWO: {
                VALUE: 2,
                MIN: 5000,
                MAX: 20000
            },
            /**20000-50000**/
            SCOPE_OF_THREE: {
                VALUE: 3,
                MIN: 20000,
                MAX: 50000
            },
            /**50000以上**/
            SCOPE_OF_FOUR: {
                VALUE: 4,
                MIN: 50000
            }
        },
    },
    /**排序方式**/
    SORT: {
        /****/
        DEFAULT: {
            VALUE: 0,
            CLOSE: 0,
            OPEN: 1
        },
        /**参考年利率 1：降序，2：升序**/
        ANNUAL_RATE: {
            VALUE: 1,
            CLOSE: 0,
            DESC: 1,
            ASC: 2
        },
        /**期限排序 1：降序，2：升序**/
        TERM: {
            VALUE: 2,
            CLOSE: 0,
            DESC: 1,
            ASC: 2
        },
        /**剩余金额 1：降序，2：升序**/
        LEFT_ANNUAL: {
            VALUE: 3,
            CLOSE: 0,
            DESC: 1,
            ASC: 2
        }

    },
    /**分页条件**/
    PAGE: {
        NOW: 1,
        SIZE: 10,
    }
}