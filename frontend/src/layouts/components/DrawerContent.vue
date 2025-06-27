<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '회원관리' }" />
        <VerticalNavLink
            :item="{
                title: '회원',
                to: '/users',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '회원정보',
                to: '/memberInfos',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '작가 관리' }" />
        <VerticalNavLink
            :item="{
                title: '작가',
                to: '/authors',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작가목록',
                to: '/authorLists',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '도서관리' }" />
        <VerticalNavLink
            :item="{
                title: '도서',
                to: '/books',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '도서',
                to: '/bookInfos',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'ai 서비스' }" />
    </ul>
</template>
