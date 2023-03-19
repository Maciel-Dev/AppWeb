import Vue from 'vue';
import Vuex, {createStore} from 'vuex';

import {auth} from './auth.module';

export default createStore({
    modules:{
        auth
    }
});
