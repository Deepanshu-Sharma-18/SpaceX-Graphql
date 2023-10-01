package com.example.learningui.data

import com.apollographql.apollo3.ApolloClient
import com.example.CompanyQuery
import com.example.LaunchPadsQuery
import com.example.LaunchQuery
import com.example.LaunchesQuery
import com.example.RocketQuery
import com.example.RocketsQuery
import com.example.ShipsQuery
import javax.inject.Inject


class GraphQlClient @Inject constructor(
    private val apolloClient: ApolloClient
) {

    suspend fun getLaunches(): List<LaunchesQuery.Launch?> {
        return (
                apolloClient
                    .query(LaunchesQuery())
                    .execute()
                    .data!!
                    .launches!!
                )
    }

    suspend fun getShips(): List<ShipsQuery.Ship?> {
        return (
                apolloClient
                    .query(ShipsQuery())
                    .execute()
                    .data!!
                    .ships!!
                )

    }

    suspend fun getLaunchPads(): List<LaunchPadsQuery.Launchpad?> {
        return (
                apolloClient
                    .query(LaunchPadsQuery())
                    .execute()
                    .data!!
                    .launchpads!!
                )
    }

    suspend fun getCompany(): CompanyQuery.Company {
        return (
                apolloClient
                    .query(CompanyQuery())
                    .execute()
                    .data!!
                    .company!!
                )

    }

    suspend fun getLaunch(launchId: String): LaunchQuery.Launch {
        return (
                apolloClient
                    .query(LaunchQuery(launchId))
                    .execute()
                    .data!!
                    .launch!!
                )
    }


    suspend fun getRocket(rocketId: String): RocketQuery.Rocket {
        return (
                apolloClient
                    .query(RocketQuery(rocketId))
                    .execute()
                    .data!!
                    .rocket!!
                )
    }

    suspend fun getRockets(): List<RocketsQuery.Rocket?> {
        return (
                apolloClient
                    .query(RocketsQuery())
                    .execute()
                    .data!!
                    .rockets!!
                )
    }

}







