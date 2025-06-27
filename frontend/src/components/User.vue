<template>
    <div>
        <String
            label="Name"
            v-model="value.name"
            :editMode="editMode"
        />
        <String
            label="Password"
            v-model="value.password"
            :editMode="editMode"
        />
        <String
            label="PhoneNumber"
            v-model="value.phoneNumber"
            :editMode="editMode"
        />
        <Date
            label="SubscriptionStartAt"
            v-model="value.subscriptionStartAt"
            :editMode="editMode"
        />
        <Date
            label="SubscriptionEndAt"
            v-model="value.subscriptionEndAt"
            :editMode="editMode"
        />
        <Number
            label="PointBalance"
            v-model="value.pointBalance"
            :editMode="editMode"
        />
        <Date
            label="CreatedAt"
            v-model="value.createdAt"
            :editMode="editMode"
        />
        <Date
            label="UpdatedAt"
            v-model="value.updatedAt"
            :editMode="editMode"
        />
        <Boolean
            label="IsKtVerified"
            v-model="value.isKtVerified"
            :editMode="editMode"
        />
        <role
            offline
            label="Role"
            v-model="value.role"
            :editMode="editMode"
            @change="change"
        />
        <SubscriptionStatus
            offline
            label="SubscriptionStatus"
            v-model="value.subscriptionStatus"
            :editMode="editMode"
            @change="change"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'User',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "users",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
