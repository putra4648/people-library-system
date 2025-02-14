import * as React from 'react'
import { Outlet, createRootRoute } from '@tanstack/react-router'
import TopbarComponent from '../components/Topbar'

export const Route = createRootRoute({
  component: RootComponent,
})

function RootComponent() {
  return (
    <React.Fragment>
      <TopbarComponent />
      <Outlet />
    </React.Fragment>
  )
}
