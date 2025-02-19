import { Outlet, createRootRoute } from "@tanstack/react-router";
import * as React from "react";
import NavbarComponent from "../components/NavbarComponent";

export const Route = createRootRoute({
  component: RootComponent,
});

function RootComponent() {
  return (
    <React.Fragment>
      <NavbarComponent />
      <Outlet />
    </React.Fragment>
  );
}
